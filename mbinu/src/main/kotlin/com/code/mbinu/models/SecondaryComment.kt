package com.code.mbinu.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document( collection = "secondaryComments" )
class SecondaryComment {
    @Id
    var id:String? = null
    var content:String? = null
    @DBRef
    var user:User? = null
    @DBRef
    var article: Article? = null
    @DBRef
    var primaryComment:PrimaryComment? = null
    var status:Status? = null
    var metadata:Metadata = Metadata()
}