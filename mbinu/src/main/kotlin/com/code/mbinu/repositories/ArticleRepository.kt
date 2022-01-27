package com.code.mbinu.repositories

import com.code.mbinu.models.Article
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.query.Param

interface ArticleRepository : MongoRepository<Article, String> {
    fun findAllByStatus( @Param("status") status: String ): List<Article>
}