package com.code.mbinu.util

import com.code.mbinu.models.Article

class ArticleUtil {
    companion object{
        fun containsAnyTag( article: Article, tagsString:String ): Boolean{
            var tags = getTags( tagsString )
            var found = false

            if( !tags.isNullOrEmpty() ){
                tags.forEach {
                    if (article.tags?.joinToString("")?.contains(it) == true){
                        found = true
                    }
                }
            }

            return found
        }

        private fun getTags(str:String ): List<String>{
            var currentIndex = 0
            val regex = Regex("[^A-Za-z0-9 ]")
            var tags = ArrayList<String>()
            for ( i in 0..str.length-1 ) {

                if( (str[i] == ' ' || str[i] == ';' || str[i] == ',') && i > 0 ){
                    var tag = regex.replace(str.substring( currentIndex, i ).trim(),"") // We remove all specials characters
                    if ( tag.isNotBlank() ){
                        tags.add( tag )
                        currentIndex = i+1
                    }
                }
                if( i == str.length-1 && i > currentIndex ){
                    var tag = regex.replace(str.substring( currentIndex, i + 1 ).trim(),"") // i + 1 because we have to include the last element too
                    if ( tag.isNotBlank() ){
                        tags.add( tag )
                    }
                }
            }
            return tags
        }
    }
}