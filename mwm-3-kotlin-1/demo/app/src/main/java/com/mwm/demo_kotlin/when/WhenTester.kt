package com.mwm.demo_kotlin.`when`

object WhenTester {

    /**
     * No additionally cost
     */
    fun basicWhen(str: String): Int {
        when (str) {
            "" -> return 1
            "c" -> return 2
            "coucou" -> return 3
        }
        return 0
    }

    fun basicWhenWithElse(str: String) = when (str) {
        "" -> 1
        "c" -> 2
        "coucou" -> 3
        else -> 0
    }

    fun whenWithComputation(integer: Int) = when (integer) {
        1 -> 1
        1 + integer -> 2
        2 + integer -> 3
        else -> 0
    }

    fun whenWithIs(x: Any) = when (x) {
        is String -> x.startsWith("prefix")
        else -> false
    }

    fun whenWithRange(integer: Int) = when (integer) {
        1 -> 1
        2, 3, 4 -> 2
        5 -> 3
        in 6..10 -> 4
        !in 30..50 -> 5
        else -> 0
    }
}