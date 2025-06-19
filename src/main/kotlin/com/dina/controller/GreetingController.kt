package com.dina.controller

import com.dina.service.GreetingsService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/greetings")
class GreetingController(val service: GreetingsService) {

    @RequestMapping("/{name}")
    fun sayHello(@PathVariable("name") name :String) :String {
        return service.getGreeting(name);


    }
}