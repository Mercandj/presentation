package com.mwm.demo_kotlin.java_interoperability

import java.io.IOException

class ThrowException {
    fun myMethodThrowException(){
        throw IOException("I throw an exception which can't be catch by java")
    }
    @Throws(IOException::class)
    fun myMethodThrowExceptionCatchableFromJava(){
        throw IOException("I throw an exception which works with Java")
    }
}