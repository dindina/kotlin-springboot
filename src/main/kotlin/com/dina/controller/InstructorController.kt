package com.dina.controller

import com.dina.dto.InstructorDTO
import com.dina.service.InstructorService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/instructors")
@Validated
class InstructorController(val instructorService: InstructorService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createInstructor( @RequestBody instructorDTO: InstructorDTO): InstructorDTO
    = instructorService.addNewInstructor(instructorDTO)

}