package edu.dickens.dickens.repository

import edu.dickens.dickens.model.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository: JpaRepository<Course, Long>