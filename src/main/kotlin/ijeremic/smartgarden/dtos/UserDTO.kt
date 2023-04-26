package ijeremic.smartgarden.dtos

data class UserDTO(
    val id: Long?,
    val username: String?,
    val password: String?,
    val email: String?,
    val role: String?
)