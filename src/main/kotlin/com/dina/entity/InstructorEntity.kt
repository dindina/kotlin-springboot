package com.dina.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name="INSTRUCTORS")
data class InstructorEntity(
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    var id: Int?,
    var name: String,
    @OneToMany(
        mappedBy = "instructor",
        cascade = [CascadeType.ALL],
        orphanRemoval = true,
        targetEntity = CourseEntity::class
    )
    var courses : List<CourseEntity> = mutableListOf()
)