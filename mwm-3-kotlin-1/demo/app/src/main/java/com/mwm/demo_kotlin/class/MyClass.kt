package com.mwm.demo_kotlin.`class`

import android.util.Log

//  simpleParameter is only usable in the init method
// `constructor` keyword can be omitted
class MyClass constructor(private val myProperty: Int, simpleParameter: Float) {

    private var anotherVal: Double = 0.0

    constructor(myProperty: Int, simpleParameter: Float, anotherSimpleParameter: Double)
            : this(myProperty, simpleParameter) {
        Log.i("MyClass", "secondary constructor")
        this.anotherVal = anotherSimpleParameter
    }

    init {
        Log.i("MyClass", "init") // is executed before secondary constructor inside
    }

}