package edu.dickens.dickens.payload

data class AddNewUserRequest(
    val username: String,
    val password: String,
    val roles: Array<String>
)
