package ru.rsu.app.entity

import javax.persistence.*

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