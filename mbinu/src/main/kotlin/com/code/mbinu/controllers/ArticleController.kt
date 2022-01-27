package com.code.mbinu.controllers

import com.code.mbinu.models.Article
import com.code.mbinu.services.ArticleService
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@Slf4j
@RestController
@RequestMapping("/mbinu/api/v1/articles")
class ArticleController( val articleService: ArticleService) {
    private val logger: Logger = LoggerFactory.getLogger( ArticleController::class.java )

    @GetMapping("")
    fun getArticles( @RequestParam("tags") tags: String? ): List<Article>? {
        logger.info("Get Articles for client")
        return articleService.findAllForClient( tags )
    }

    @GetMapping("/admin")
    fun getArticlesForAdmin( @RequestParam("tags") tags: String? ): List<Article>? {
        logger.info("Get Articles for Admin ")
        return articleService.findAllForAdmin( tags )
    }

    @GetMapping("/article")
    fun getArticleById(@RequestHeader("articleId") articleId: String): Article? {
        logger.info("Get Article By Id : $articleId")
        return articleService.findById( articleId )
    }

    @PostMapping("")
    @ResponseBody
    fun create(@RequestBody article: Article): Article? {
        logger.info("Article create request: $article")
        return articleService.create( article )
    }

    @PostMapping("/update")
    @ResponseBody
    fun update(@RequestBody article: Article): Article? {
        logger.info("Article update request: $article")
        return articleService.update( article )
    }

    @PostMapping("/delete")
    @ResponseBody
    fun delete( @RequestHeader("articleId") articleId: String ): Boolean? {
        logger.info("Article delete request id: $articleId")
        return articleService.delete( articleId )
    }
}