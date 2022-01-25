package com.code.mbinu.models

import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class Metadata {
    var created: LocalDateTime? = null
    var modified:LocalDateTime? = null
    var views: Long = 0
}