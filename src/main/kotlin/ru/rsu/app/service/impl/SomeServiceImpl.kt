package ru.rsu.app.service.impl

import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import ru.rsu.app.dto.SomeEntityDto
import ru.rsu.app.entity.SomeEntity
import ru.rsu.app.repository.SomeEntityRepository
import ru.rsu.app.service.SomeService

@Service
class SomeServiceImpl(
    private val someEntityRepository: SomeEntityRepository
) : SomeService {
    val DEAFULT_PAGE_SIZE = 2;
    override fun getAll(pageIndex: Int): List<SomeEntityDto> {
        return someEntityRepository.findByOrderByName(PageRequest.of(pageIndex,DEAFULT_PAGE_SIZE))
            .map { it.toDto() };
    }

    private fun SomeEntity.toDto(): SomeEntityDto =
        SomeEntityDto(
            id = this.id,
            name = this.name,
            population = this.population
        )
}