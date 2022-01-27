package com.code.mbinu.controllers

import com.code.mbinu.models.Status
import com.code.mbinu.models.User
import com.code.mbinu.services.UserService
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@Slf4j
@RestController
@RequestMapping("/mbinu/api/v1/users")
class UserController( val userService: UserService) {
    private val logger: Logger = LoggerFactory.getLogger( UserController::class.java )

    @GetMapping("")
    fun getUsers(): List<User>? {
        logger.info("Get Players for Client ")
        return userService.findAllByStatus( Status.ENABLED.toString() )
    }

    @GetMapping("/admin")
    fun getUsersForAdmin(): List<User>? {
        logger.info("Get Players for Admin ")
        return userService.findAll()
    }

    @GetMapping("/user")
    fun getUserById(@RequestHeader("userId") userId: String): User? {
        logger.info("Get User By Id : $userId")
        return userService.findById( userId )
    }

    @PostMapping("")
    @ResponseBody
    fun create(@RequestBody user: User): User? {
        logger.info("User create request: $user")
        return userService.create( user )
    }

    @PostMapping("/update")
    @ResponseBody
    fun update(@RequestBody user: User): User? {
        logger.info("User update request: $user")
        return userService.update( user )
    }

    @PostMapping("/delete")
    @ResponseBody
    fun delete( @RequestHeader("userId") userId: String ): Boolean? {
        logger.info("User delete request id: $userId")
        return userService.delete( userId )
    }
}