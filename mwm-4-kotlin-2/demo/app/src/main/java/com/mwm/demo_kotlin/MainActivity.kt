package com.mwm.demo_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import com.mwm.demo_kotlin.`class`.MyClass
import com.mwm.demo_kotlin.`object`.OtherActivity
import com.mwm.demo_kotlin.default_parameter.EventManager
import com.mwm.demo_kotlin.inheritance.Labrador
import com.mwm.demo_kotlin.jni.BridgeJni

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.activity_main_text_view)

        val labrador = Labrador(5)
        labrador.myOpenedFunction()

        val myClass = MyClass(5, 6f, 9.0)

        val eventManager = EventManager()
        eventManager.sendEvent(abtest = "variation_a")

        findViewById<View>(R.id.btn_start_other_activity).setOnClickListener {
            OtherActivity.startActivity(this)
        }

        val jniString = BridgeJni.getString()
        Log.d("MainActivity", jniString)
    }
}
