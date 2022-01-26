package com.code.mbinu.services

import com.code.mbinu.models.PrimaryComment

interface PrimaryCommentService {
    fun create( primaryComment: PrimaryComment ): PrimaryComment?
    fun update( primaryComment: PrimaryComment ): PrimaryComment?
    fun findById( primaryCommentId: String ): PrimaryComment?
    fun findAll(): List<PrimaryComment>?
    fun findAllByStatus( status: String ): List<PrimaryComment>?
    fun delete( primaryCommentId: String ): Boolean?
}