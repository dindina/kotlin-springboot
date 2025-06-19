package com.dina.repository

import com.dina.entity.CourseEntity
import org.springframework.data.repository.CrudRepository

interface CourseRepository : CrudRepository<CourseEntity,Int> {

}