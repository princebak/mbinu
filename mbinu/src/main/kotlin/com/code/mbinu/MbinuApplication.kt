package com.code.mbinu

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import springfox.documentation.swagger2.annotations.EnableSwagger2
import kotlin.streams.toList

@SpringBootApplication
@EnableSwagger2
class MbinuApplication{
	companion object{
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(MbinuApplication::class.java, *args)
			println("prin;ce".contains("[;]"))
			println("prin ce".contains("[;]"))
		}
		fun conAny( article:MonArticle ): Boolean{
			var tags = getTags("eb;,,,en")
			var found = false
			if( tags.isNotEmpty() ){
				tags.forEach {
					if ( article.tags.joinToString("").contains(it) )
						found = true
				}
			}

			println(found)
			return found
		}

		fun getTags( str:String ): List<String>{
			var currentIndex = 0
			var tags = ArrayList<String>()

			for ( i in 0..str.length-1 ) {

				if( (str[i] == ' ' || str[i] == ';' || str[i] == ',') && i > 0 ){
					var tag = str.substring( currentIndex, i ).trim()
							.replace(";","").replace(" ","").replace(",","").trim()
					if ( tag.isNotBlank() ){
						tags.add( tag )
						currentIndex = i+1
					}
				}
				if( i == str.length-1 && i > currentIndex ){
					var tag = str.substring( currentIndex, i+1 ).trim()
							.replace(";","").replace(" ","").replace(",","").trim()
					if ( tag.isNotBlank() ){
						tags.add( tag )
					}
				}
			}
			tags.forEach { println(it) }
			println("Size"+tags.size)
			return tags
		}

		class MonArticle{
			var name:String? = null
			var tags:ArrayList<String> = ArrayList<String>()
		}
	}

	@Bean
	fun configurer(): WebMvcConfigurer? {
		return object : WebMvcConfigurer {
			override fun addCorsMappings(registry: CorsRegistry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("*")
						.allowedHeaders("*")
			}
		}
	}


}
