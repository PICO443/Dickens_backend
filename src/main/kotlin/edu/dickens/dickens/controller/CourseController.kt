package edu.dickens.dickens.controller

import edu.dickens.dickens.model.Course
import edu.dickens.dickens.repository.CourseRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/course")
class CourseController(
    @Autowired val courseRepository: CourseRepository
) {


    @GetMapping
    fun getAll(): List<Course>{
        return courseRepository.findAll()
    }
}