package com.code.mbinu.services.managers

import com.code.mbinu.models.SecondaryComment
import com.code.mbinu.models.Status
import com.code.mbinu.models.User
import com.code.mbinu.repositories.SecondaryCommentRepository
import com.code.mbinu.services.SecondaryCommentService
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class SecondaryCommentManager( val secondaryCommentRepository: SecondaryCommentRepository): SecondaryCommentService {
    override fun create( secondaryComment: SecondaryComment ): SecondaryComment? {
        secondaryComment.metadata.created = LocalDateTime.now()
        return secondaryCommentRepository.save( secondaryComment )
    }

    override fun update( secondaryComment: SecondaryComment ): SecondaryComment? {
        secondaryComment.metadata.modified = LocalDateTime.now()
        return secondaryCommentRepository.save( secondaryComment )
    }

    override fun findById( secondaryCommentId: String ): SecondaryComment? {
        return secondaryCommentRepository.findById( secondaryCommentId ).orElse( null )
    }

    override fun findAll(): List<SecondaryComment>? {
        return secondaryCommentRepository.findAll()
    }

    override fun delete( secondaryCommentId: String ): Boolean? {
        return try{
            var secondaryComment: SecondaryComment = findById( secondaryCommentId )!!
            secondaryComment.status = Status.DISABLED
            update( secondaryComment )
            true
        }catch ( ex: Exception ){
            false
        }
    }
}