package com.example.mymovieapp.framework.ui.common

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mymovieapp.R

class ElementHeaderActivity @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {
    init {
        val view = LayoutInflater
            .from(context)
            .inflate(R.layout.element_header_activity, this, true)
    }
}