package com.dina.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "Courses")
data class CourseEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id : Int?,
    var name : String,
    var category : String
)


