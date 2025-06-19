package com.dina.controller

import com.dina.service.GreetingsService
import com.ninjasquad.springmockk.MockkBean
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import io.mockk.every
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.reactive.server.WebTestClient


@WebMvcTest(controllers = [GreetingController::class])
@AutoConfigureWebTestClient
class GreetingControllerUnitTest {

    @MockkBean
    lateinit var greetingServiceMock: GreetingsService

    @Autowired
    lateinit var webTestClient: WebTestClient


    @Test
    fun retrieveGreeting() {

        val name = "dilip"

        every { greetingServiceMock.getGreeting(any()) } returns  "$name, Hello from default profile"

        val result =webTestClient.get()
            .uri("/v1/greetings/{name}", name)
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBody(String::class.java)
            .returnResult()

        assertEquals("$name, Hello from default profile", result.responseBody)

    }
}