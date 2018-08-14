package com.mwm.demo_kotlin.jni

class BridgeJni {

    companion object {

        @JvmStatic
        external fun getString(): String

        init {
            System.loadLibrary("cpp-api")
        }
    }
}