package com.dina.controller

import com.dina.service.GreetingsService
import mu.KLogging
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/greetings")
class GreetingController(val service: GreetingsService) {

    companion object: KLogging()

    @RequestMapping("/{name}")
    fun sayHello(@PathVariable("name") name :String) :String {
        logger.info("in controller $name")
        return service.getGreeting(name);


    }
}