package com.code.mbinu.services.managers

import com.code.mbinu.models.PrimaryComment
import com.code.mbinu.models.Status
import com.code.mbinu.repositories.PrimaryCommentRepository
import com.code.mbinu.services.PrimaryCommentService
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class PrimaryComponentManager( val primaryCommentRepository: PrimaryCommentRepository): PrimaryCommentService {
    override fun create( primaryComment: PrimaryComment ): PrimaryComment? {
        primaryComment.metadata.created =  LocalDateTime.now()
        return primaryCommentRepository.save( primaryComment )
    }

    override fun update(primaryComment: PrimaryComment): PrimaryComment? {
        primaryComment.metadata.modified =  LocalDateTime.now()
        return primaryCommentRepository.save( primaryComment )
    }

    override fun findById(primaryCommentId: String): PrimaryComment? {
        return primaryCommentRepository.findById( primaryCommentId ).orElse( null )
    }

    override fun findAll(): List<PrimaryComment>? {
        return primaryCommentRepository.findAll()
    }

    override fun delete(primaryCommentId: String): Boolean? {
        return try{
            var primaryComment: PrimaryComment = findById( primaryCommentId )!!
            primaryComment.status = Status.DISABLED
            update( primaryComment )
            true
        }catch ( ex: Exception ){
            false
        }
    }
}