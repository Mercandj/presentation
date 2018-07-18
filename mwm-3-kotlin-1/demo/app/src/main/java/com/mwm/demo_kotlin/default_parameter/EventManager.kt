package com.mwm.demo_kotlin.default_parameter

import android.util.Log

class EventManager {
    fun sendEvent(eventType: String? = null, abtest: String){
        val message = "{\"eventType\": \"$eventType\"," +
                " \"abtest\": \"$abtest\"}"
        Log.i("EventManager", message)
    }
}