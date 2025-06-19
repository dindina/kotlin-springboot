package com.dina.repository

import com.dina.entity.InstructorEntity
import org.springframework.data.repository.CrudRepository

interface InstructorRepository : CrudRepository<InstructorEntity, Int> {

    fun findInstructorByName(name : String) : InstructorEntity
}