package com.nugurang.entity

import com.nugurang.dto.WorkDto
import javax.persistence.*

@Entity
@Table(
    name = "work",
    uniqueConstraints = [UniqueConstraint(columnNames = ["project", "name"]), UniqueConstraint(columnNames = ["project", "name", "order"])]
)
class WorkEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var order: Int,

    @Column(nullable = false)
    var opened: Boolean,

    @ManyToOne
    @JoinColumn(name = "project", nullable = false)
    var project: ProjectEntity

) : BaseEntity<WorkDto> {
    override fun toDto(): WorkDto {
        return WorkDto(id!!, name, order, opened)
    }
}