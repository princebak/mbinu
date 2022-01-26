package com.code.mbinu.repositories

import com.code.mbinu.models.PrimaryComment
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.query.Param

interface PrimaryCommentRepository : MongoRepository<PrimaryComment, String> {
    fun findAllByStatus(@Param("status") status: String): List<PrimaryComment>
}