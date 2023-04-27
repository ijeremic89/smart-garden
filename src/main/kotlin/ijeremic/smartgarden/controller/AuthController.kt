package ijeremic.smartgarden.controller

import ijeremic.smartgarden.dtos.LoginDTO
import ijeremic.smartgarden.dtos.LoginResponseDTO
import ijeremic.smartgarden.dtos.RegisterDTO
import ijeremic.smartgarden.enums.UserCreationStatus
import ijeremic.smartgarden.services.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val userService: UserService
) {

    @PostMapping("/login")
    fun login(@RequestBody loginDTO: LoginDTO): LoginResponseDTO {
        return userService.login(loginDTO)
    }

    @PostMapping("/register")
    fun register(@RequestBody registerDTO: RegisterDTO): UserCreationStatus {
        return userService.register(registerDTO)
    }
}