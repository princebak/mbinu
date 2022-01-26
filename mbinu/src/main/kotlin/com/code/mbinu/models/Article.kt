package com.code.mbinu.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document( collection = "articles" )
class Article {
    @Id
    var id:String? = null
    var title:String? = null
    var shortDescription:String? = null
    var longDescription:String? = null
    var example:String? = null
    var tags:ArrayList<String>?=null
    var category:ArticleCategory? = null
    var publisherName:String? = null
    var primaryComments:ArrayList<PrimaryComment>? = null
    var metadata:Metadata = Metadata()
    var status:Status? = null
}