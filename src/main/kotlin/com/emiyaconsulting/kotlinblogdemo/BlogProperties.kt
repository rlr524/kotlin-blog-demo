package com.emiyaconsulting.kotlinblogdemo

import org.springframework.boot.Banner
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("blog")
data class BlogProperties(var title: String, val banner: Banner) {
    data class Banner(val title: String? = null, val content: String)
}