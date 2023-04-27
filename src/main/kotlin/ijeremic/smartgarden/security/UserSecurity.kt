package ijeremic.smartgarden.security

import ijeremic.smartgarden.entities.UserEntity
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserSecurity
    (private val userEntity: UserEntity,
) : UserDetails {
    override fun getAuthorities() = userEntity.role.map { SimpleGrantedAuthority(it.toString()) }
    override fun getPassword() = userEntity.password
    override fun getUsername() = userEntity.username
    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true
    override fun isCredentialsNonExpired()= true
    override fun isEnabled() = true
}