package com.mwm.demo_kotlin.destructuring

object Destructuring {

    fun create() = Pojo("id", ArrayList() )

    fun destructuring() {
        val (id, videosIds) = create()
    }

    data class Pojo(val id: String, val videosIds: List<String>)
}