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
    private val logger: Logger = LoggerFactory.getLogger( SecondaryCommentController::class.java )

    @GetMapping("")
    fun getSecondaryComments(): List<SecondaryComment>? {
        logger.info("Get Players for Client ")
        return secondaryCommentService.findAllByStatus( Status.ENABLED.toString() )
    }

    @GetMapping("/admin")
    fun getSecondaryCommentsForAdmin(): List<SecondaryComment>? {
        logger.info("Get Players for Admin")
        return secondaryCommentService.findAll()
    }

    @GetMapping("/secondaryComment")
    fun getSecondaryCommentById(@RequestHeader("secondaryCommentId") secondaryCommentId: String): SecondaryComment? {
        logger.info("Get SecondaryComment By Id : $secondaryCommentId")
        return secondaryCommentService.findById( secondaryCommentId )
    }

    @PostMapping("")
    @ResponseBody
    fun create(@RequestBody secondaryComment: SecondaryComment): SecondaryComment? {
        logger.info("SecondaryComment create request: $secondaryComment")
        return secondaryCommentService.create( secondaryComment )
    }

    @PostMapping("/update")
    @ResponseBody
    fun update(@RequestBody secondaryComment: SecondaryComment): SecondaryComment? {
        logger.info("SecondaryComment update request: $secondaryComment")
        return secondaryCommentService.update( secondaryComment )
    }

    @PostMapping("/delete")
    @ResponseBody
    fun delete( @RequestHeader("secondaryCommentId") secondaryCommentId: String ): Boolean? {
        logger.info("SecondaryComment delete request id: $secondaryCommentId")
        return secondaryCommentService.delete( secondaryCommentId )
    }
}