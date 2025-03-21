package com.emiyaconsulting.kotlinblogdemo

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BlogProperties::class)
class KotlinBlogDemoApplication

fun main(args: Array<String>) {
    runApplication<KotlinBlogDemoApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}
