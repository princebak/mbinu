package com.code.mbinu.services.managers

import com.code.mbinu.models.Article
import com.code.mbinu.models.Status
import com.code.mbinu.models.User
import com.code.mbinu.repositories.ArticleRepository
import com.code.mbinu.services.ArticleService
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ArticleManager( val articleRepository: ArticleRepository ): ArticleService {
    override fun create( article: Article ): Article? {
        article.metadata.created = LocalDateTime.now()
        return articleRepository.save( article )
    }

    override fun update(article: Article): Article? {
        article.metadata.modified = LocalDateTime.now()
        return articleRepository.save( article )
    }

    override fun findById(articleId: String): Article? {
        var article = articleRepository.findById( articleId ).orElse( null )
        article.metadata.views += 1
        return article
    }

    override fun findAll(): List<Article>? {
        return articleRepository.findAll()
    }

    override fun delete( articleId: String ): Boolean? {
        return try{
            var article: Article = findById( articleId )!!
            article.status = Status.DISABLED
            update( article )
            true
        }catch ( ex: Exception ){
            false
        }
    }
}