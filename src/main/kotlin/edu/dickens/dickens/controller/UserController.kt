package edu.dickens.dickens.controller

import edu.dickens.dickens.payload.AddNewUserRequest
import edu.dickens.dickens.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {

    @PostMapping
    fun add(addNewUserRequest: AddNewUserRequest){

        userService.addUser(addNewUserRequest)
    }
}