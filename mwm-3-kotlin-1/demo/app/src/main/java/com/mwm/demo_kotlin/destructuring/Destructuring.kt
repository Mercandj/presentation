package com.mwm.demo_kotlin.destructuring

object Destructuring {

    fun create() = Pojo("id", ArrayList())

    fun destructuring(): String {
        val (id, videosIds) = create()
        if (videosIds.isEmpty()) {
            throw IllegalStateException()
        }
        return id
    }

    data class Pojo(val id: String, val videosIds: List<String>)
}