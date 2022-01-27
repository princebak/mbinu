package com.code.mbinu.controllers

import com.code.mbinu.models.PrimaryComment
import com.code.mbinu.models.Status
import com.code.mbinu.services.PrimaryCommentService
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@Slf4j
@RestController
@RequestMapping("/mbinu/api/v1/primary-comments")
class PrimaryCommentController( val primaryCommentService: PrimaryCommentService ) {
    private val LOGGER: Logger = LoggerFactory.getLogger( PrimaryCommentController::class.java )

    @GetMapping("")
    fun getPrimaryComments(): List<PrimaryComment>? {
        LOGGER.info("Get Players ")
        return primaryCommentService.findAllByStatus( Status.ENABLED.toString() )
    }

    @GetMapping("/admin")
    fun getPrimaryCommentsForAdmin(): List<PrimaryComment>? {
        LOGGER.info("Get Players ")
        return primaryCommentService.findAll()
    }

    @GetMapping("/primaryComment")
    fun getPrimaryCommentById(@RequestHeader("primaryCommentId") primaryCommentId: String): PrimaryComment? {
        LOGGER.info("Get PrimaryComment By Id : $primaryCommentId")
        return primaryCommentService.findById( primaryCommentId )
    }

    @PostMapping("")
    @ResponseBody
    fun create(@RequestBody primaryComment: PrimaryComment): PrimaryComment? {
        LOGGER.info("PrimaryComment create request: $primaryComment")
        return primaryCommentService.create( primaryComment )
    }

    @PostMapping("/update")
    @ResponseBody
    fun update(@RequestBody primaryComment: PrimaryComment): PrimaryComment? {
        LOGGER.info("PrimaryComment create request: $primaryComment")
        return primaryCommentService.update( primaryComment )
    }

    @PostMapping("/delete")
    @ResponseBody
    fun delete( @RequestHeader("primaryCommentId") primaryCommentId: String ): Boolean? {
        LOGGER.info("PrimaryComment delete request id: $primaryCommentId")
        return primaryCommentService.delete( primaryCommentId )
    }
}