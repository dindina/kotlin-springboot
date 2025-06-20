package com.dina.controller

import com.dina.dto.CourseDto
import com.dina.service.CourseService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/courses")
@Validated
class CourseController(val courseService: CourseService) {

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun addCourse(@RequestBody @Valid courseDto: CourseDto): CourseDto {

        return courseService.addCourse(courseDto)

    }

    @GetMapping
    fun getCourses() : List<CourseDto>{
        return courseService.getCourses()
    }

    @PutMapping("/{course_id}")
    fun updateCourse(@PathVariable("course_id") courseId : Int, @RequestBody courseDto: CourseDto) : CourseDto{
        return courseService.updateCourse(courseId, courseDto)
    }

    @DeleteMapping("/{course_id}")
    fun deleteCourse(@PathVariable("course_id") courseId : Int) : CourseDto{
        return courseService.deleteCourse(courseId)
    }
}