package com.code.mbinu.repositories

import com.code.mbinu.models.PrimaryComment
import org.springframework.data.mongodb.repository.MongoRepository

interface PrimaryCommentRepository : MongoRepository<PrimaryComment, String> {
}