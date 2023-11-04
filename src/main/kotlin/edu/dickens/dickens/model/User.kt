package edu.dickens.dickens.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
data class User(
    @Id val username: String = "",
    val password: String = "",
    @ManyToMany(cascade = [CascadeType.ALL])
    val roles: List<UserRole> = emptyList<UserRole>().toMutableList()
)

fun User.toUserDetailsImpl(): UserDetails {
    return UserDetailsImpl(this)
}


class UserDetailsImpl(private val user: User) : UserDetails {

    override fun getUsername(): String {
        return user.username
    }

    override fun getPassword(): String {
        return user.password
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return user.roles.map { it.toGrantedAuthorityImpl() }.toMutableList()
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

}
