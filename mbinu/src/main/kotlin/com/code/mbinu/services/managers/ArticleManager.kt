package com.code.mbinu.services.managers

import com.code.mbinu.models.Article
import com.code.mbinu.models.Status
import com.code.mbinu.repositories.ArticleRepository
import com.code.mbinu.services.ArticleService
import com.code.mbinu.util.ArticleUtil
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ArticleManager( val articleRepository: ArticleRepository ): ArticleService {
    override fun create( article: Article ): Article? {
        article.status = Status.ENABLED
        article.metadata.created = LocalDateTime.now()
        return articleRepository.save( article )
    }

    override fun update( article: Article ): Article? {
        article.metadata.modified = LocalDateTime.now()
        return articleRepository.save( article )
    }

    override fun findById( articleId: String ): Article? {
        var article = articleRepository.findById( articleId ).orElse( null )
        article.metadata.views += 1
        return article
    }

    override fun findAllForAdmin( tags: String? ): List<Article>? {
        if( tags == null ){
            return articleRepository.findAll()
        }
        return articleRepository.findAll().filter { ArticleUtil.containsAnyTag( it, tags ) }
    }

    override fun findAllForClient(tags: String? ): List<Article>? {
        if( tags == null ){
            return articleRepository.findAllByStatus( Status.ENABLED.toString() )
        }
        return articleRepository.findAllByStatus( Status.ENABLED.toString() ).filter { ArticleUtil.containsAnyTag( it, tags ) }
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