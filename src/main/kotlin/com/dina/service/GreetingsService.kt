package com.dina.service

import org.springframework.stereotype.Service

@Service
class GreetingsService {
    fun getGreeting(name :String)  = "Hello $name"

}