package com.code.mbinu.repositories

import com.code.mbinu.models.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, String> {
}