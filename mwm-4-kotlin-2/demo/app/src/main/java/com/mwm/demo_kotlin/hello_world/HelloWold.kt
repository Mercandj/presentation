package com.mwm.demo_kotlin.hello_world

import android.util.Log

fun start(): String = "Hello World"

fun printTwice(message: String) {
    Log.d("jm/debug", "$message " + message)
}