package com.mwm.demo_kotlin.java_interoperability

import android.util.Log

class Interoperability {
    companion object {
        const val TAG = "Interoperability"
        @JvmField val myVar = 5
        @JvmStatic fun myStaticFunctionInJava() {
            Log.i("OtherActivity", "My static function in java in Interoperability")
        }
        fun myNotStaticFunctionInJava() {
            Log.i("OtherActivity", "My not static function in java in Interoperability")
        }
    }
}