package ijeremic.smartgarden.controller

import ijeremic.smartgarden.dtos.UserDTO
import ijeremic.smartgarden.services.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {
    @GetMapping("/getUser/{id}")
    fun getPlant(@PathVariable id: Long): UserDTO {
        return userService.findById(id)
    }
}