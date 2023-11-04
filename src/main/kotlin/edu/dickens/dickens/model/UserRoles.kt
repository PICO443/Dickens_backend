package edu.dickens.dickens.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.security.core.GrantedAuthority

@Entity
data class UserRole(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Int = 0,
    val name: String = "",
)

fun UserRole.toGrantedAuthorityImpl() : GrantedAuthority{
    return GrantedAuthorityImpl(this)
}

class GrantedAuthorityImpl(private val userRole: UserRole): GrantedAuthority {

    override fun getAuthority(): String {
        return userRole.name
    }

}
