package com.dina.dto

import jakarta.validation.constraints.NotBlank

data class InstructorDTO(
    val id: Int?,
    val name: String
)