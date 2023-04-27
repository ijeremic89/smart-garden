package ijeremic.smartgarden.services

import ijeremic.smartgarden.dtos.LoginDTO
import ijeremic.smartgarden.dtos.LoginResponseDTO
import ijeremic.smartgarden.dtos.RegisterDTO
import ijeremic.smartgarden.entities.UserEntity
import ijeremic.smartgarden.enums.UserCreationStatus
import ijeremic.smartgarden.enums.UserRole
import ijeremic.smartgarden.repositories.UserRepository
import ijeremic.smartgarden.security.HashService
import ijeremic.smartgarden.security.JwtTokenUtil
import org.apache.commons.validator.routines.EmailValidator
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val repository: UserRepository,
    private val hashService: HashService,
    private val jwtTokenUtil: JwtTokenUtil
) {

    fun login(loginDTO: LoginDTO): LoginResponseDTO {
        val optionalUser = repository.findByEmail(loginDTO.email)
        if (optionalUser.isEmpty ||
            !optionalUser.get().password.let { hashService.checkBcrypt(loginDTO.password, it) }
        ) {
            throw BadCredentialsException("Invalid username/password supplied")
        }

        return LoginResponseDTO(
            token = jwtTokenUtil.generateToken(loginDTO.email),
            email = optionalUser.get().email,
        )
    }

    fun register(registerDTO: RegisterDTO): UserCreationStatus {
        val emailError = validateNewUser(registerDTO.email, repository.findByEmail(registerDTO.email).isPresent)
        if (emailError.isPresent) {
            return emailError.get()
        }

        return save(
            UserEntity(
                username = registerDTO.email.split('@')[0],
                email = registerDTO.email,
                password = hashService.hashBcrypt(registerDTO.password),
                role = UserRole.ROLE_USER.name,
                firstName = registerDTO.firstName,
                lastName = registerDTO.lastName,
                dateOfBirth = registerDTO.dateOfBirth,
                createdDate = Calendar.getInstance().time
            )
        )
    }

    fun validateNewUser(email: String, doesUserExist: Boolean): Optional<UserCreationStatus> {
        if (!EmailValidator.getInstance().isValid(email))
            return Optional.of(UserCreationStatus.INVALID_EMAIL)
        if (doesUserExist)
            return Optional.of(UserCreationStatus.ALREADY_EXISTS)
        return Optional.empty<UserCreationStatus>()
    }

    fun save(userEntity: UserEntity): UserCreationStatus {
        repository.save(userEntity)
        return UserCreationStatus.SUCCESS
    }
}