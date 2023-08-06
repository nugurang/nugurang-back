package com.nugurang.task

import com.nugurang.constant.RoleName
import com.nugurang.dao.MatchRequestDao
import com.nugurang.dao.RoleDao
import com.nugurang.dao.TeamDao
import com.nugurang.dao.XrefUserTeamDao
import com.nugurang.entity.MatchRequestEntity
import com.nugurang.entity.RoleEntity
import com.nugurang.entity.TeamEntity
import com.nugurang.entity.XrefUserTeamEntity
import com.nugurang.exception.NotFoundException
import com.nugurang.service.NotificationService
import io.github.oshai.kotlinlogging.KotlinLogging
import net.time4j.Moment
import net.time4j.range.IntervalTree
import net.time4j.range.MomentInterval
import net.time4j.range.ValueInterval
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.time.Instant
import java.time.OffsetDateTime
import java.util.*
import kotlin.math.max
import kotlin.math.min

@Component
class MatchTask(
    private val notificationService: NotificationService,
    private val matchRequestDao: MatchRequestDao,
    private val roleDao: RoleDao,
    private val teamDao: TeamDao,
    private val xrefUserTeamDao: XrefUserTeamDao
) {
    private val logger = KotlinLogging.logger {}

    //@Scheduled(fixedDelay = 10000)
    @Transactional
    private fun matchRequests() {

        val expiredMatchRequestEntities = matchRequestDao.findAllByExpiresAtLessThan(OffsetDateTime.now())

        for (expiredMatchRequestEntity in expiredMatchRequestEntities) {
            notificationService.createMatchFailureNotification(
                expiredMatchRequestEntity.user,
                expiredMatchRequestEntity.type,
                expiredMatchRequestEntity.event
            )
            matchRequestDao.deleteById(expiredMatchRequestEntity.id!!)
        }

        // https://github.com/MenoData/Time4J/issues/674
        // should filter by random match and event
        val matchRequestIntervals = matchRequestDao
        .findAll()
        .asSequence()
        .map { matchRequestEntity ->
            matchRequestEntity
            .maxTeamSize
            ?.let { maxTeamSize ->
                MomentInterval
                .between(
                    Instant.ofEpochSecond(matchRequestEntity.minTeamSize as Long),
                    Instant.ofEpochSecond(maxTeamSize as Long)
                )
                .withValue(matchRequestEntity)
            }
            ?: MomentInterval.since(Instant.ofEpochSecond(matchRequestEntity.minTeamSize as Long))
            .withValue(matchRequestEntity)
        }
        .shuffled()
        .toList()

        if (matchRequestIntervals.size < 2)
            return

        val intervalTree = IntervalTree.onMomentAxis(matchRequestIntervals)
        val matchRequestInterval = matchRequestIntervals[0]
        val otherMatchRequestIntervals = intervalTree
            .findIntersections(matchRequestInterval)
            .asSequence()
            .filter { it.value.id !== it.value.id }
            .shuffled()
            .toList()

        logger.info { "intervals: ${otherMatchRequestIntervals.size}" }
        val matchRequestEntity = matchRequestInterval.value
        var min = matchRequestEntity.minTeamSize
        var max = matchRequestEntity.maxTeamSize ?: Int.MAX_VALUE
        val matchedRequestIntervals: MutableList<ValueInterval<Moment, MomentInterval, MatchRequestEntity>> = LinkedList()
        for (otherMatchRequestInterval in otherMatchRequestIntervals) {
            val otherMatchRequestEntity = otherMatchRequestInterval.value
            val currentMin = otherMatchRequestEntity.minTeamSize
            val currentMax = otherMatchRequestEntity.maxTeamSize ?: Int.MAX_VALUE
            min = max(min, currentMin)
            max = min(max, currentMax)
            if (matchedRequestIntervals.size + 1 >= max) break
            matchedRequestIntervals.add(otherMatchRequestInterval)
        }
        logger.info { "matched ${matchedRequestIntervals.size} users and min is $min" }
        if (matchedRequestIntervals.size + 1 < min) return
        val teamEntity = teamDao.save(TeamEntity(name = UUID.randomUUID().toString()))
        xrefUserTeamDao.save(
            XrefUserTeamEntity(
                user = matchRequestEntity.user,
                team = teamEntity,
                role = roleDao.findByName(RoleName.OWNER.name) ?: throw NotFoundException(RoleEntity::class.java)
            )
        )
        matchRequestDao.deleteById(matchRequestEntity.id!!)
        notificationService.createMatchSuccessNotification(
            matchRequestEntity.user,
            matchRequestEntity.type,
            matchRequestEntity.event,
            teamEntity
        )
        for (matchedRequestInterval in matchedRequestIntervals) {
            val matchedRequestEntity = matchedRequestInterval.value
            notificationService.createMatchSuccessNotification(
                matchedRequestEntity.user,
                matchedRequestEntity.type,
                matchedRequestEntity.event,
                teamEntity
            )
            xrefUserTeamDao.save(
                XrefUserTeamEntity(
                    user = matchedRequestEntity.user,
                    team = teamEntity,
                    role = roleDao.findByName(RoleName.MEMBER.name) ?: throw NotFoundException(RoleEntity::class.java)
                )
            )
            matchRequestDao.deleteById(matchedRequestEntity.id!!)
        }
        logger.info { "match task" }
    }
}
