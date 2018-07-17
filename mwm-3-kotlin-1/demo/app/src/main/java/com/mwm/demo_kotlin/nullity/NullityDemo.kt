package com.mwm.demo_kotlin.nullity

import android.util.Log

class NullityDemo(
        nonNullString: String,
        nullableString: String?
) {
    init {
        Log.d("", nonNullString)
    }
}