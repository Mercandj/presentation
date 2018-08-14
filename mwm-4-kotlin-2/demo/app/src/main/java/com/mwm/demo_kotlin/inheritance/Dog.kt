package com.mwm.demo_kotlin.inheritance

import android.util.Log

open class Dog(age: Int) : Animal(age) {

    init {
        Log.i(TAG, "init 1")
    }

    fun myFunction() {
        Log.i(TAG, "myFunction")
    }

    override fun myOpenedFunction() {
        Log.i(TAG, "myOpenedFunction")
    }

    init {
        Log.i(TAG, "init 2")
    }

    companion object {
        private const val TAG = "Dog"
    }

}