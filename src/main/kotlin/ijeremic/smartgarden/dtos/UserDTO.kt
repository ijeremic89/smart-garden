package ijeremic.smartgarden.dtos

import java.util.*

data class UserDTO(
    val id: Long,
    val username: String,
    val password: String,
    val email: String,
    val role: String,
    val firstName: String,
    val lastName: String,
    val dateOfBirth: Date,
    val createdDate: Date
)