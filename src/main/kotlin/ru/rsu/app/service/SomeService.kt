package ru.rsu.app.service

import ru.rsu.app.dto.SomeEntityDto

interface SomeService {
    fun getAll(pageIndex : Int): List<SomeEntityDto>
}