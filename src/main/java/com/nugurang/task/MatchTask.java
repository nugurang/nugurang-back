package com.nugurang.task;

import com.nugurang.constant.RoleName;
import com.nugurang.dao.MatchRequestDao;
import com.nugurang.dao.RoleDao;
import com.nugurang.dao.TeamDao;
import com.nugurang.dao.XrefUserTeamDao;
import com.nugurang.entity.MatchRequestEntity;
import com.nugurang.entity.TeamEntity;
import com.nugurang.entity.XrefUserTeamEntity;
import com.nugurang.service.NotificationService;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import net.time4j.Moment;
import net.time4j.range.IntervalTree;
import net.time4j.range.MomentInterval;
import net.time4j.range.ValueInterval;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MatchTask {
    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MatchTask.class);
    //</editor-fold>
    private final NotificationService notificationService;
    private final MatchRequestDao matchRequestDao;
    private final RoleDao roleDao;
    private final TeamDao teamDao;
    private final XrefUserTeamDao xrefUserTeamDao;

    @Scheduled(fixedDelay = 10000)
    @Transactional
    private void matchRequests() {
        final var expiredMatchRequestEntities = matchRequestDao.findAllByExpiresAtLessThan(OffsetDateTime.now());
        for (final var expiredMatchRequestEntity : expiredMatchRequestEntities) {
            notificationService.createMatchFailureNotification(expiredMatchRequestEntity.getUser(), expiredMatchRequestEntity.getType(), expiredMatchRequestEntity.getEvent());
            matchRequestDao.deleteById(expiredMatchRequestEntity.getId());
        }
        // https://github.com/MenoData/Time4J/issues/674
        // should filter by random match and event
        List<ValueInterval<Moment, MomentInterval, MatchRequestEntity>> matchRequestIntervals = matchRequestDao.findAll().stream().map(matchRequestEntity -> Optional.ofNullable(matchRequestEntity.getMaxTeamSize()).map(maxTeamSize -> MomentInterval.between(Instant.ofEpochSecond(matchRequestEntity.getMinTeamSize()), Instant.ofEpochSecond(maxTeamSize)).withValue(matchRequestEntity)).orElseGet(() -> MomentInterval.since(Instant.ofEpochSecond(matchRequestEntity.getMinTeamSize())).withValue(matchRequestEntity))).collect(Collectors.toList());
        if (matchRequestIntervals.size() < 2) return;
        Collections.shuffle(matchRequestIntervals);
        IntervalTree<Moment, ValueInterval<Moment, MomentInterval, MatchRequestEntity>> intervalTree = IntervalTree.onMomentAxis(matchRequestIntervals);
        final var matchRequestInterval = matchRequestIntervals.get(0);
        var otherMatchRequestIntervals = intervalTree.findIntersections(matchRequestInterval).stream().filter(otherMatchRequestInterval -> otherMatchRequestInterval.getValue().getId() != matchRequestInterval.getValue().getId()).collect(Collectors.toList());
        Collections.shuffle(otherMatchRequestIntervals);
        log.info("intervals " + otherMatchRequestIntervals.size());
        final var matchRequestEntity = matchRequestInterval.getValue();
        int min = matchRequestEntity.getMinTeamSize();
        int max = Optional.ofNullable(matchRequestEntity.getMaxTeamSize()).orElse(Integer.MAX_VALUE);
        List<ValueInterval<Moment, MomentInterval, MatchRequestEntity>> matchedRequestIntervals = new LinkedList<>();
        for (final var otherMatchRequestInterval : otherMatchRequestIntervals) {
            final var otherMatchRequestEntity = otherMatchRequestInterval.getValue();
            int currentMin = otherMatchRequestEntity.getMinTeamSize();
            int currentMax = Optional.ofNullable(otherMatchRequestEntity.getMaxTeamSize()).orElse(Integer.MAX_VALUE);
            min = Math.max(min, currentMin);
            max = Math.min(max, currentMax);
            if (matchedRequestIntervals.size() + 1 >= max) break;
            matchedRequestIntervals.add(otherMatchRequestInterval);
        }
        log.info("matched " + matchedRequestIntervals.size() + " users and min is " + min);
        if (matchedRequestIntervals.size() + 1 < min) return;
        TeamEntity teamEntity = teamDao.save(TeamEntity.builder().name(UUID.randomUUID().toString()).build());
        xrefUserTeamDao.save(XrefUserTeamEntity.builder().user(matchRequestEntity.getUser()).team(teamEntity).role(roleDao.findByName(RoleName.OWNER.name())).build());
        matchRequestDao.deleteById(matchRequestEntity.getId());
        notificationService.createMatchSuccessNotification(matchRequestEntity.getUser(), matchRequestEntity.getType(), matchRequestEntity.getEvent(), teamEntity);
        for (ValueInterval<Moment, MomentInterval, MatchRequestEntity> matchedRequestInterval : matchedRequestIntervals) {
            final var matchedRequestEntity = matchedRequestInterval.getValue();
            notificationService.createMatchSuccessNotification(matchedRequestEntity.getUser(), matchedRequestEntity.getType(), matchedRequestEntity.getEvent(), teamEntity);
            xrefUserTeamDao.save(XrefUserTeamEntity.builder().user(matchedRequestEntity.getUser()).team(teamEntity).role(roleDao.findByName(RoleName.MEMBER.name())).build());
            matchRequestDao.deleteById(matchedRequestEntity.getId());
        }
        log.info("match task");
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public MatchTask(final NotificationService notificationService, final MatchRequestDao matchRequestDao, final RoleDao roleDao, final TeamDao teamDao, final XrefUserTeamDao xrefUserTeamDao) {
        this.notificationService = notificationService;
        this.matchRequestDao = matchRequestDao;
        this.roleDao = roleDao;
        this.teamDao = teamDao;
        this.xrefUserTeamDao = xrefUserTeamDao;
    }
    //</editor-fold>
}
