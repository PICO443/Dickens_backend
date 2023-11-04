package edu.dickens.dickens.service

import edu.dickens.dickens.model.User
import edu.dickens.dickens.model.UserRole
import edu.dickens.dickens.payload.AddNewUserRequest
import edu.dickens.dickens.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository, private val passwordEncoder: PasswordEncoder) {

    fun addUser(addNewUserRequest: AddNewUserRequest){
        if(userRepository.existsById(addNewUserRequest.username)) throw IllegalStateException("There is a user with the same username exist!")
        addNewUserRequest.run {
            userRepository
                .save(User(
                    username = username,
                    password = passwordEncoder.encode(password),
                    roles = mutableListOf(UserRole(name = "ADMIN2"))
                ))
        }
    }
}