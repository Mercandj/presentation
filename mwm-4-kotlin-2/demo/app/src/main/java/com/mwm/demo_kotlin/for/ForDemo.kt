package com.mwm.demo_kotlin.`for`

import android.util.Log
import java.util.*

object ForDemo {

    private const val TAG = "ForDemo"

    private val list = ArrayList<Int>()

    // Additionally cost
    // An IntRange is temporary allocated
    fun testForEachOnRange() {
        (1..10).forEach {
            Log.i(TAG, "i : $it")
        }
    }

    fun testForEachOnIterator() {
        list.forEach {
            Log.i(TAG, "i : $it")
        }
    }

    fun testForEachOnIterator2() {
        for (myVal in list) {
            Log.i(TAG, "i : $myVal")
        }
    }

    fun testForWithIndices() {
        for(i in list.indices){
            Log.i(TAG, "i : " + list[i])
        }
    }

}