package com.dina.dto


import jakarta.validation.constraints.NotBlank


data class CourseDto(

    val id : Int?,
    @get:NotBlank(message = "name must not be blank")
    val name : String,
    @get:NotBlank(message = "category must not be blank")
    val category : String,
    val instructorId: Int? = null





)
