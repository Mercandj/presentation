package com.mwm.demo_kotlin.destructuring

@Suppress("unused")
object Destructuring {

    fun extractJohnName(): String {
        val (name, _, _) = createJohn()
        return name
    }

    fun getJohnToString(): String {
        val (name, age, vip) = createJohn()
        return "$name $age $vip"
    }

    private fun createJohn() = User("john", 25, true)

    data class User(
            val name: String,
            val age: Int,
            val vip: Boolean
    )
}