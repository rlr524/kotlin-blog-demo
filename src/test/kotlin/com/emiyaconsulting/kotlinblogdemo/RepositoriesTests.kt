package com.emiyaconsulting.kotlinblogdemo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull
import kotlin.test.Test
import kotlin.test.assertEquals

@DataJpaTest
class RepositoriesTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val userRepository: UserRepository,
    val articleRepository: ArticleRepository) {
    
    @Test
    fun `When finByIdOrNull then return Article`() {
        val johnDoe = BlogUser("johnDoe", "John", "Doe")
        entityManager.persist(johnDoe)
        val article = Article("Lorem", "Lorem", "dolor sit amet", johnDoe)
        entityManager.persist(article)
        entityManager.flush()
        // Kotlin uses a !! to force unwrap potential null values. In general, it is unwise to use !!, just as it is
        // to do force unwrapping in Swift, however in this case, because we're running a test to check if an article
        // exists or not, it is appropriate to allow a NullPointerException if the value unwraps to null.
        val found = articleRepository.findByIdOrNull(article.id!!)
        assertEquals(found, article)
    }
    
    @Test
    fun `When findByLogin then return User`() {
        val johnDoe = BlogUser("johnDoe", "John", "Doe")
        entityManager.persist(johnDoe)
        entityManager.flush()
        val user = userRepository.findByLogin(johnDoe.login)
        assertEquals(user, johnDoe)
    }
}