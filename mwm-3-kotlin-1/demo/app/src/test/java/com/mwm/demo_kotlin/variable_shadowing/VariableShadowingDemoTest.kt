package com.mwm.demo_kotlin.variable_shadowing

import org.junit.Assert
import org.junit.Test

class VariableShadowingDemoTest {

    @Test
    fun exampleOutput() {
        val list = VariableShadowingDemo().exampleOfVariableShadowing()
        Assert.assertEquals("str-parameter", list[0])
        Assert.assertEquals("str-constructor", list[1])
        Assert.assertEquals("str-local-variable", list[2])
        Assert.assertEquals("str-constructor", list[3])
    }
}