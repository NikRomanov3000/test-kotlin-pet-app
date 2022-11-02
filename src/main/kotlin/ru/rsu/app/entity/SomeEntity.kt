package ru.rsu.app.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.GenerationType
import javax.persistence.Column

@Entity
@Table(name = "country")
class SomeEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    @Column(name = "name")
    val name: String = "",
    @Column(name = "population")
    val population: Int = 0
)
