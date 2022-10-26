package ru.rsu.app.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.rsu.app.dto.SomeEntityDto
import ru.rsu.app.service.SomeService

@RestController
@RequestMapping("/countries")
class SomeController(private val service: SomeService) {

    @GetMapping
    fun getAllEntities(@RequestParam page:Int): List<SomeEntityDto> {
       return service.getAll(page)
    }
}