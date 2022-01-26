package com.code.mbinu.services

import com.code.mbinu.models.SecondaryComment

interface SecondaryCommentService {
    fun create( secondaryComment: SecondaryComment ): SecondaryComment?
    fun update( secondaryComment: SecondaryComment ): SecondaryComment?
    fun findById( secondaryCommentId: String ): SecondaryComment?
    fun findAll(): List<SecondaryComment>?
    fun findAllByStatus( status: String ): List<SecondaryComment>?
    fun delete( secondaryCommentId: String ): Boolean?
}