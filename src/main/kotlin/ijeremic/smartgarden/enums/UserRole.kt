package ijeremic.smartgarden.enums

enum class UserRole {
    ROLE_ADMIN,
    ROLE_USER
}

fun getAllUserRoles() : Array<UserRole> {
    return arrayOf(UserRole.ROLE_USER, UserRole.ROLE_ADMIN)
}