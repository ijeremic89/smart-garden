package ijeremic.smartgarden.entities

import ijeremic.smartgarden.dtos.UserDTO
import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "user")
open class UserEntity(

    @Column(name = "username", nullable = false, length = 25)
    open var username: String? = null,

    @Column(name = "password", nullable = false, length = 25)
    open var password: String? = null,

    @Column(name = "email", nullable = false, unique = true, length = 25)
    open var email: String? = null,

    @Column(name = "role")
    open var role: String? = null,
) : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    fun toDto(): UserDTO = UserDTO(
        id = id,
        email = email,
        username = username,
        password = password,
        role = role,
    )
}