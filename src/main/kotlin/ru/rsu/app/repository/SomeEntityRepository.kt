package ru.rsu.app.repository

import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import ru.rsu.app.entity.SomeEntity

interface SomeEntityRepository : CrudRepository<SomeEntity, Long> {
    fun findByOrderByName(pageable: Pageable): List<SomeEntity>
}
