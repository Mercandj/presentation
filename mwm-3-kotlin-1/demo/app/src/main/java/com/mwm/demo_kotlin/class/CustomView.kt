package com.mwm.demo_kotlin.`class`

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.mwm.demo_kotlin.R

class CustomView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val textView: TextView

    init {
        View.inflate(context, R.layout.view_custom, this)
        textView = findViewById(R.id.view_custom_text_view)
    }
}