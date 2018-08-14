package com.mwm.demo_kotlin.any

import java.util.*

object AnyTester {

    fun anyList(): List<Any> {
        val list = ArrayList<Any>(1)
        list.add("Coucou")
        return list
    }

}