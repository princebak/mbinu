package com.code.mbinu.repositories

import com.code.mbinu.models.SecondaryComment
import org.springframework.data.mongodb.repository.MongoRepository

interface SecondaryCommentRepository: MongoRepository<SecondaryComment, String> {
}