package com.code.mbinu.repositories

import com.code.mbinu.models.SecondaryComment
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.query.Param

interface SecondaryCommentRepository: MongoRepository<SecondaryComment, String> {
    fun findAllByStatus(@Param("status") status: String): List<SecondaryComment>
}