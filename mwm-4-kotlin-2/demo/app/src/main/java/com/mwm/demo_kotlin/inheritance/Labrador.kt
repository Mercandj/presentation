package com.mwm.demo_kotlin.inheritance

import android.util.Log

class Labrador(value: Int) : Dog(value) {

    init {
        Log.i(TAG, "init")

        super.myFunction()
    }

    override fun myOpenedFunction() {
        super.myOpenedFunction()
        Log.i(TAG, "myOpenedFunction")
    }

// myFunction is not open, so it's final in Java and we can't override it
//  override fun myFunction(){ // not possible
//
//  }

    companion object {
        private const val TAG = "Labrador"
    }

}