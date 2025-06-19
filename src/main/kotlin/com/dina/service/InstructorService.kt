package com.dina.service

import com.dina.entity.InstructorEntity
import com.dina.dto.InstructorDTO
import com.dina.repository.InstructorRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class InstructorService(val instructorRepository: InstructorRepository) {

    fun addNewInstructor(instructorDTO: InstructorDTO): InstructorDTO {

        val instructorEntity = instructorDTO.let {
            InstructorEntity(it.id, it.name)
        }

        instructorRepository.save(instructorEntity)

        return instructorEntity.let {
            InstructorDTO(it.id, it.name)
        }
    }

    fun findInstructorById(instructorId: Int): Optional<InstructorEntity> {

        return  instructorRepository.findById(instructorId)
    }
}