package com.dina.service

import com.dina.dto.CourseDto
import com.dina.entity.CourseEntity
import com.dina.exception.CourseNotFoundException
import com.dina.repository.CourseRepository
import mu.KLogging
import org.springframework.stereotype.Service

@Service
class CourseService(val courseRepository: CourseRepository) {

    companion object : KLogging()

    fun addCourse(courseDto: CourseDto): CourseDto {
        logger.info("course $courseDto")
        val entity = courseDto.let {
            CourseEntity(null, it.name, it.category)
        }
        courseRepository.save(entity)

        return entity.let {
            CourseDto(it.id, it.name, it.category)
        }

    }

    fun getCourses(): List<CourseDto> {
        return courseRepository.findAll().map {
            CourseDto(it.id, it.name, it.category)
        }
    }

    fun updateCourse(courseId: Int, courseDto: CourseDto): CourseDto {
        val existingCourse = courseRepository.findById(courseId)
        return if (existingCourse.isPresent) {
            existingCourse.get()
                .let {
                    it.name = courseDto.name
                    it.category = courseDto.category
                    courseRepository.save(it)
                    CourseDto(it.id, it.name, it.category)
                }
        } else {
            throw CourseNotFoundException("No course found")
        }

    }

    fun deleteCourse(courseId: Int): CourseDto {
        val existingCourse = courseRepository.findById(courseId)
        return if (existingCourse.isPresent) {
            existingCourse.get()
                .let {
                    courseRepository.deleteById(courseId)
                    CourseDto(it.id, it.name, it.category)
                }
        } else {
            throw CourseNotFoundException("No course found")
        }


    }
}