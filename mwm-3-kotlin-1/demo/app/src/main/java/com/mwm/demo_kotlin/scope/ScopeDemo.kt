package com.mwm.demo_kotlin.scope

import android.app.Notification
import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.View

class ScopeDemo(val context: Context) {

    private var a = 5
    private var view = View(context)

    private var notifbuilder: Notification.Builder? = Notification.Builder(context)

    fun testRun() {
        run {
            val a = 10
            Log.i("ScopeDemo", "a : $a")
            Log.i("ScopeDemo", "this:a : " + this.a)
        }
    }

    fun testViewRun() {
        view.run {
            alpha = 0.5f
            isEnabled = true
        }
    }

    fun testRunReturn(): Notification {
        return Notification.Builder(context).run {
            setContentTitle("Title")
            setContentText("Message")
            build()
        }
    }

    fun testLet1Return(): Notification? {
        return notifbuilder?.let {
            it.setContentTitle("Title")
            it.setContentText("Message")
            it.build()
        }
    }

    fun testLet2Return(): Notification {
        return Notification.Builder(context).let { me ->
            me.setContentTitle("Title")
            me.setContentText("Message")
            me.build()
        }
    }

    fun testApply() {
        val paint = Paint().apply {
            color = Color.MAGENTA
            style = Paint.Style.STROKE
        }
    }

    fun testAlso() {
        val paint = Paint().also {
            it.color = Color.MAGENTA
            it.style = Paint.Style.STROKE
        }
    }

    fun testWith() {
        with(view) {
            this.alpha = 0.5f
            isEnabled = true
        }
    }

}