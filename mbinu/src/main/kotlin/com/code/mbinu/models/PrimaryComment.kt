package com.code.mbinu.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document( collection = "primaryComments" )
class PrimaryComment {
    @Id
    var id:String? = null
    var content:String? = null
    @DBRef
    var user:User? = null
    @DBRef
    var article: Article? = null
    var secondaryComments:ArrayList<SecondaryComment>? = null
    var status:Status? = null
    var metadata:Metadata = Metadata()
}