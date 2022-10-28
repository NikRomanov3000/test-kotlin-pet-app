package ru.rsu.app.dto

import io.swagger.annotations.ApiModelProperty

data class SomeEntityDto(
    @ApiModelProperty("Идентификатор элемента")
    val id: Long,
    @ApiModelProperty("Название страны")
    val name: String,
    @ApiModelProperty("Население")
    val population: Int
)
