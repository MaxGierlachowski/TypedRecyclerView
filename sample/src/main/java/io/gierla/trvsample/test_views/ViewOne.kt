package io.gierla.trvsample.test_views

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class ViewOne @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : AppCompatTextView(context, attrs, defStyleAttr) {

    init {
        minimumHeight = 200
        setBackgroundColor(Color.BLACK)
        setTextColor(Color.WHITE)
        gravity = Gravity.CENTER
    }

}