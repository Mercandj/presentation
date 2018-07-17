package com.mwm.demo_kotlin.nullity

import android.util.Log

class NullityDemo(
        nonNullString: String,
        nullableString: String?
) {
    init {
        Log.d("", nonNullString)
    }

    fun isStringEmptySafe(str: String?): Boolean {
        return str?.length == 0
    }

    fun isStringEmpty(str: String?): Boolean {
        return str!!.isEmpty()
    }
}