package com.mwm.demo_kotlin.`object`

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK

class OtherActivity : Activity() {

    companion object Utils {
        const val TAG = "OtherActivity"
        fun startActivity(context: Context){
            val intent = Intent(context, OtherActivity::class.java)
            if(context !is Activity){
                intent.flags = FLAG_ACTIVITY_NEW_TASK and FLAG_ACTIVITY_CLEAR_TASK
            }
            context.startActivity(intent)
        }
    }
}