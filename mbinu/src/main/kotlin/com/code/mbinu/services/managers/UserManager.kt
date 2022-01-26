package com.code.mbinu.services.managers

import com.code.mbinu.models.Status
import com.code.mbinu.models.User
import com.code.mbinu.repositories.UserRepository
import com.code.mbinu.services.UserService
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserManager(val userRepository: UserRepository):UserService {
    override fun create( user: User ): User? {
        user.status = Status.ENABLED
        user.metadata.created = LocalDateTime.now()
        return userRepository.save( user )
    }

    override fun update(user: User): User? {
        user.metadata.modified = LocalDateTime.now()
        return userRepository.save( user )
    }

    override fun findById(userId: String): User? {
        var user = userRepository.findById( userId ).orElse( null )
        user.metadata.views += 1
        return user
    }

    override fun findAll(): List<User>? {
        return userRepository.findAll()
    }

    override fun findAllByStatus(status: String): List<User>? {
        return userRepository.findAllByStatus( status )
    }

    override fun delete( userId: String ): Boolean? {
        return try{
            var user:User = findById( userId )!!
            user.status = Status.DISABLED
            update( user )
            true
        }catch ( ex: Exception ){
            false
        }
    }
}