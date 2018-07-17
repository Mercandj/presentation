package com.mwm.demo_kotlin.inheritance

import android.util.Log

open class Animal(age: Int) {

    init {
        Log.i(TAG, "init")
        Log.i(TAG, "age : $age")
    }

    open fun myOpenedFunction() {
        Log.i(TAG, "myOpenedFunction")
    }

    companion object {
        private const val TAG = "Animal"
    }

}