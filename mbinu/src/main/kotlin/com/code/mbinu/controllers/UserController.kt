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
    private val LOGGER: Logger = LoggerFactory.getLogger( UserController::class.java )

    @GetMapping("")
    fun getUsers(): List<User>? {
        LOGGER.info("Get Players ")
        return userService.findAllByStatus( Status.ENABLED.toString() )
    }

    @GetMapping("/admin")
    fun getUsersForAdmin(): List<User>? {
        LOGGER.info("Get Players ")
        return userService.findAll()
    }

    @GetMapping("/user")
    fun getUserById(@RequestHeader("userId") userId: String): User? {
        LOGGER.info("Get User By Id : $userId")
        return userService.findById( userId )
    }

    @PostMapping("")
    @ResponseBody
    fun create(@RequestBody user: User): User? {
        LOGGER.info("User create request: $user")
        return userService.create( user )
    }

    @PostMapping("/update")
    @ResponseBody
    fun update(@RequestBody user: User): User? {
        LOGGER.info("User create request: $user")
        return userService.update( user )
    }

    @PostMapping("/delete")
    @ResponseBody
    fun delete( @RequestHeader("userId") userId: String ): Boolean? {
        LOGGER.info("User delete request id: $userId")
        return userService.delete( userId )
    }
}