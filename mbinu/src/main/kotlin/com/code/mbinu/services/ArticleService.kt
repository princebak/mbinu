package com.code.mbinu.services

import com.code.mbinu.models.Article

interface ArticleService {
    fun create( article: Article ): Article?
    fun update( article: Article ): Article?
    fun findById( articleId: String ): Article?
    fun findAllForAdmin( tags: ArrayList<String>? ): List<Article>?
    fun findAllForClient( tags: ArrayList<String>? ): List<Article>?
    fun delete( articleId: String ): Boolean?
}