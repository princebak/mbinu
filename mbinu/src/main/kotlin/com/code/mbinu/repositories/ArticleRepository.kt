package com.code.mbinu.repositories

import com.code.mbinu.models.Article
import org.springframework.data.mongodb.repository.MongoRepository

interface ArticleRepository : MongoRepository<Article, String> {
}