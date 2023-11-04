package edu.dickens.dickens.repository

import edu.dickens.dickens.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, String> {
    fun findUserByUsername(username: String): User?
}