package edu.dickens.dickens.model

import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import java.time.LocalDate

@Entity
data class Student(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    val name: String = "",
    @Embedded val address: Address = Address(),
    val DateOfBirth: LocalDate = LocalDate.now(),
    @Enumerated val qualifications: Qualifications = Qualifications.MIDDLE_SCHOOL,
    @ManyToMany val appliedCourses: List<AppliedCourse> = emptyList()
)

@Embeddable
data class Address(
    var current: String = "",
    var permanent: String = ""
)

enum class Qualifications{
    SCHOOL,
    MIDDLE_SCHOOL,
    SECONDARY_SCHOOL,
    UNIVERSITY
}

@Entity
data class AppliedCourse(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    @ManyToOne val course: Course = Course(),
    @ManyToOne val teacher: Teacher = Teacher(),
    val appliedDate: LocalDate = LocalDate.now(),
    val feeFirstInstallment: Int = 0,
    val feeSecondInstallment: Int = 0,
    val payedFee: Int = 0
)
