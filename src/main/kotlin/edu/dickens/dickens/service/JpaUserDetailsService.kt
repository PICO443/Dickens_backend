package edu.dickens.dickens.service

import edu.dickens.dickens.model.toUserDetailsImpl
import edu.dickens.dickens.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class JpaUserDetailsService(
    @Autowired val userRepository: UserRepository
): UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String?): UserDetails {
        if(username == null) throw UsernameNotFoundException("You entered an empty username !")
        return userRepository.findUserByUsername(username)?.toUserDetailsImpl() ?: throw UsernameNotFoundException("User with username: $username not found !")
    }
}