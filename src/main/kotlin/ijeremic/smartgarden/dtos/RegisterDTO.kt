package ijeremic.smartgarden.dtos

import java.util.Date

data class RegisterDTO(
    val email: String,
    val password: String,
    val role: String,
    val firstName: String,
    val lastName: String,
    val dateOfBirth: Date
)
