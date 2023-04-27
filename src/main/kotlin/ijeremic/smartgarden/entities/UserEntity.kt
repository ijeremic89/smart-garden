package ijeremic.smartgarden.entities

import ijeremic.smartgarden.dtos.UserDTO
import jakarta.persistence.*
import java.io.Serializable
import java.util.Date

@Entity
@Table(name = "users")
open class UserEntity(

    @Column(name = "username", nullable = false, length = 25)
    open var username: String = "",

    @Column(name = "password", nullable = false, length = 100)
    open var password: String = "",

    @Column(name = "email", nullable = false, unique = true, length = 25)
    open var email: String = "",

    @Column(name = "role", nullable = false, unique = true, length = 25)
    open var role: String = "",

    @Column(name = "first_name", length = 25)
    open var firstName: String = "",

    @Column(name = "last_name", length = 25)
    open var lastName: String = "",

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.TIMESTAMP)
    open var dateOfBirth: Date = Date(),

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    open var createdDate: Date = Date(),

) : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long = 0

    fun toDto(): UserDTO = UserDTO(
        id = id,
        email = email,
        username = username,
        password = password,
        role = role,
        firstName = firstName,
        lastName = lastName,
        dateOfBirth = dateOfBirth,
        createdDate = createdDate
    )
}