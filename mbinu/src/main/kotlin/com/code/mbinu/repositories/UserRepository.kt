package com.code.mbinu.repositories

import com.code.mbinu.models.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.query.Param

interface UserRepository : MongoRepository<User, String> {
    fun findAllByStatus(@Param("status") status: String): List<User>
}