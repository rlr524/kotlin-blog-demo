package com.emiyaconsulting.kotlinblogdemo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus
import kotlin.test.Test
import kotlin.test.assertEquals
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTests(@Autowired val restTemplate: TestRestTemplate) {
    @BeforeAll
    fun setup() {
        println(">> Setup")
    }
    
    @Test
    fun `Assert blog page title, content and status code`() {
        println(">> Assert blog page title, content and status code")
        val entity = restTemplate.getForEntity<String>("/")
        assertEquals(entity.statusCode, HttpStatus.OK)
        assertThat(entity.body, containsString("<h1>Blog</h1>"))
    }
    
    @Test
    fun `Assert article page title, content and status code`() {
        println(">> TODO")
    }
    
    @AfterAll
    fun teardown() {
        println(">> Tear down")
    }
}