package com.code.mbinu.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document( collection = "users" )
class User {
    @Id
    var id:String? = null
    var firstName:String? = null
    var lastName:String? = null
    @Indexed
    var userName:String? = null
    var password:String? = null
    @Indexed
    var email:String? = null
    var status:Status? = null
    var metadata:Metadata = Metadata()
}