package com.code.mbinu.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document( collection = "articles" )
class Article {
    @Id
    var id:String? = null
    var publisherName:String? = null
    var content:String? = null
    var category:ArticleCategory? = null
    var primaryComments:ArrayList<PrimaryComment>? = null
    var metadata:Metadata = Metadata()
    var status:Status? = null
}