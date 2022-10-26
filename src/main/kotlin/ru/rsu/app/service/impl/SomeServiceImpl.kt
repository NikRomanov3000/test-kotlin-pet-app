package ru.rsu.app.service.impl

import org.springframework.stereotype.Service
import ru.rsu.app.dto.SomeEntityDto
import ru.rsu.app.service.SomeService
@Service
class SomeServiceImpl : SomeService {
    override fun getAll(): List<SomeEntityDto> {
        return listOf(
            SomeEntityDto(1, "Germany", 80_000_000),
            SomeEntityDto(2, "Russia", 146_000_000));
    }
}