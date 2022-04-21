package io.github.grishaninvyacheslav.my_courses_viewer.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import io.github.grishaninvyacheslav.my_courses_viewer.databinding.ViewTimerBinding

class Timer : FrameLayout {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ){
        addView(binding.root)
    }

    private val binding = ViewTimerBinding.inflate(LayoutInflater.from(context))
}