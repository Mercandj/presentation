package com.mwm.demo_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.mwm.demo_kotlin.`class`.MyClass
import com.mwm.demo_kotlin.`object`.OtherActivity
import com.mwm.demo_kotlin.default_parameter.EventManager
import com.mwm.demo_kotlin.inheritance.Labrador

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val labrador = Labrador(5)
        labrador.myOpenedFunction()

        val myClass = MyClass(5, 6f, 9.0)

        val eventManager = EventManager()
        eventManager.sendEvent(abtest = "variation_a")

        findViewById<View>(R.id.btn_start_other_activity).setOnClickListener {
            OtherActivity.startActivity(this)
        }
    }
}
