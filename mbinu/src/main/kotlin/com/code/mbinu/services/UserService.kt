package com.code.mbinu.services

import com.code.mbinu.models.User

interface UserService {
    fun create( user: User ): User?
    fun update( user: User ): User?
    fun findById( userId: String ): User?
    fun findAll(): List<User>?
    fun findAllByStatus( status: String ): List<User>?
    fun delete( userId: String ): Boolean?
}