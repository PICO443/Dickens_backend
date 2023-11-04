package edu.dickens.dickens.model

import jakarta.persistence.Entity
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
data class Teacher(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    val name: String = "",
    @Enumerated val department: Department = Department.ENGLISH,
    @OneToMany val courses: List<AppliedCourse> = emptyList()
)

enum class Department{
    COMPUTER,
    ENGLISH,
    ARABIC,
    CHEMISTRY
}
