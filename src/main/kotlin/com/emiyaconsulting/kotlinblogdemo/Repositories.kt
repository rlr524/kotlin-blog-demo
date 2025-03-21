package com.emiyaconsulting.kotlinblogdemo

import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Article, Long> {
    fun findBySlug(slug: String): Article?
    fun findAllByOrderByAddedAtDesc(): Iterable<Article>
}

interface UserRepository : CrudRepository<BlogUser, Long> {
    fun findByLogin(login: String): BlogUser?
}