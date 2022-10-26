package ru.rsu.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication


@SpringBootApplication(exclude = arrayOf(DataSourceAutoConfiguration::class))
class TestKotlinAppApplication

fun main(args: Array<String>) {
    runApplication<TestKotlinAppApplication>(*args)
}
