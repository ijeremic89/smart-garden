package ijeremic.smartgarden.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtTokenUtil(
    @Value("\${security.jwtSecret}")
    private val jwtKey: String,

    @Value("\${security.jwtExpirationMs}")
    private val jwtExpirationMs: Int
) {

    fun generateToken(email: String): String =
        Jwts.builder()
            .setIssuedAt(Calendar.getInstance().time)
            .setExpiration(Date(System.currentTimeMillis() + jwtExpirationMs))
            .setSubject(email)
            .claim("email", email)
            .signWith(SignatureAlgorithm.HS512, jwtKey.toByteArray())
            .compact()

    private fun getClaims(token: String) =
        Jwts.parser().setSigningKey(jwtKey.toByteArray()).parseClaimsJws(token).body

    fun getEmail(token: String): String = getClaims(token).subject

    fun isTokenValid(token: String): Boolean {
        val claims = getClaims(token)
        val expirationDate = claims.expiration
        val now = Date(System.currentTimeMillis())
        return now.before(expirationDate)
    }
}