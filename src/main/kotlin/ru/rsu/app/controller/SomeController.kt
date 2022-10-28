package ru.rsu.app.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.rsu.app.dto.SomeEntityDto
import ru.rsu.app.service.SomeService

@RestController
@RequestMapping("/api/countries")
@Api(description = "Тестовый контроллер")
class SomeController(private val service: SomeService) {

    @GetMapping("/getAll")
    @ApiOperation("Получение всех элементов с учётом пагинации")
    fun getAllEntities(@RequestParam page:Int): List<SomeEntityDto> {
       return service.getAll(page)
    }
}