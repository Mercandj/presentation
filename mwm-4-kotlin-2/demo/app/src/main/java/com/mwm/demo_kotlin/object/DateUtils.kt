package com.mwm.demo_kotlin.`object`

import java.util.*

// object can't have a constructor
object DateUtils {

    fun getCurrentDate(): Date {
        return Calendar.getInstance().time
    }

    fun getCurrentTime(): Long{
        return Calendar.getInstance().time.time
    }

}