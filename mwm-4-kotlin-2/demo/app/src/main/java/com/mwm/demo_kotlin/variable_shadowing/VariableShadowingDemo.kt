package com.mwm.demo_kotlin.variable_shadowing

class VariableShadowingDemo(
        private val str: String = "str-constructor"
) {

    fun exampleOfVariableShadowing(
            str: String = "str-parameter"
    ): List<String> {
        val list = ArrayList<String>()
        list.add(str)
        list.add(this.str)
        val str = "str-local-variable"
        list.add(str)
        list.add(this.str)
        return list
    }
}