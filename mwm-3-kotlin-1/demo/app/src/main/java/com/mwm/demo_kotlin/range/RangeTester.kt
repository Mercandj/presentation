package com.mwm.demo_kotlin.range

import android.util.Log

object RangeTester {

    private const val TAG = "RangeTester"

    //private val customRange get() = 1..10

    // No additionally cost
    fun basicRange(){
        for(i in 1..10){
            Log.i(TAG, "i : $i")
        }
    }

    // No additionally cost
    fun downToRange(){
        for(i in 10 downTo 1){
            Log.i(TAG, "i : $i")
        }
    }

    // No additionally cost
    // Equivalent to the downTo example
    fun reversedRange(){
        for (i in (1..10).reversed()) {
            Log.i(TAG, "i : $i")
        }
    }

    // Exclude the upper value
    // No additionally cost
    fun untilRange(){
        for(i in 0 until 10){
            Log.i(TAG, "i : $i")
        }
    }

    // /!\ Additionally cost
    // An IntRange and an IntProgression are temporary created
    fun stepRange(){
        for(i in 0..10 step 2){
            Log.i(TAG, "i : $i")
        }
    }

    // Additionally cost due to external range creation
    // An IntRange is temporary created
    fun oneMorelLevelRange(){
        val customRange = 1..10
        for(i in customRange){
            Log.i(TAG, "i : $i")
        }
    }

}