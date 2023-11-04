package edu.dickens.dickens.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Course(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    val name: String = "",
    val periodDays: Int = 0,
    val fee: Int = 0
)
