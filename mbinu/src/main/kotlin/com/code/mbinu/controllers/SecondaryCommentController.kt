package com.code.mbinu.controllers

import com.code.mbinu.models.SecondaryComment
import com.code.mbinu.models.Status
import com.code.mbinu.services.SecondaryCommentService
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@Slf4j
@RestController
@RequestMapping("/mbinu/api/v1/secondary-comments")
class SecondaryCommentController( val secondaryCommentService: SecondaryCommentService ) {
    private val LOGGER: Logger = LoggerFactory.getLogger( SecondaryCommentController::class.java )

    @GetMapping("")
    fun getSecondaryComments(): List<SecondaryComment>? {
        LOGGER.info("Get Players ")
        return secondaryCommentService.findAllByStatus( Status.ENABLED.toString() )
    }

    @GetMapping("/admin")
    fun getSecondaryCommentsForAdmin(): List<SecondaryComment>? {
        LOGGER.info("Get Players ")
        return secondaryCommentService.findAll()
    }

    @GetMapping("/secondaryComment")
    fun getSecondaryCommentById(@RequestHeader("secondaryCommentId") secondaryCommentId: String): SecondaryComment? {
        LOGGER.info("Get SecondaryComment By Id : $secondaryCommentId")
        return secondaryCommentService.findById( secondaryCommentId )
    }

    @PostMapping("")
    @ResponseBody
    fun create(@RequestBody secondaryComment: SecondaryComment): SecondaryComment? {
        LOGGER.info("SecondaryComment create request: $secondaryComment")
        return secondaryCommentService.create( secondaryComment )
    }

    @PostMapping("/update")
    @ResponseBody
    fun update(@RequestBody secondaryComment: SecondaryComment): SecondaryComment? {
        LOGGER.info("SecondaryComment create request: $secondaryComment")
        return secondaryCommentService.create( secondaryComment )
    }

    @PostMapping("/delete")
    @ResponseBody
    fun delete( @RequestHeader("secondaryCommentId") secondaryCommentId: String ): Boolean? {
        LOGGER.info("SecondaryComment delete request id: $secondaryCommentId")
        return secondaryCommentService.delete( secondaryCommentId )
    }
}