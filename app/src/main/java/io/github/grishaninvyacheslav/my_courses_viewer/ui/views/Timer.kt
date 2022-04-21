package io.github.grishaninvyacheslav.my_courses_viewer.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import io.github.grishaninvyacheslav.my_courses_viewer.databinding.ViewTimerBinding
import io.github.grishaninvyacheslav.my_courses_viewer.utils.MINUTES_IN_DAY
import io.github.grishaninvyacheslav.my_courses_viewer.utils.MINUTES_IN_HOUR
import io.github.grishaninvyacheslav.my_courses_viewer.utils.getDigit
import java.lang.RuntimeException

class Timer : FrameLayout {
    private val maxTotalMinutes = 143999

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        addView(binding.root)
    }

    fun setTime(daysLeft: Int, hoursLeft: Int, minutesLeft: Int) = with(binding) {
        val totalMinutesLeft = daysLeft * MINUTES_IN_DAY + hoursLeft * MINUTES_IN_HOUR + minutesLeft
        if (totalMinutesLeft > maxTotalMinutes) {
            throw RuntimeException("io.github.grishaninvyacheslav.my_courses_viewer.ui.views.Timer поддерживает только неотрицательное время не превышающее 99 дней 23 часов и 59 минут")
        }

        val daysDisplayValue = totalMinutesLeft / MINUTES_IN_DAY
        daysDigit1.text = daysDisplayValue.getDigit(1).toString()
        daysDigit2.text = daysDisplayValue.getDigit(0).toString()

        val hoursDisplayValue = (totalMinutesLeft - daysDisplayValue * MINUTES_IN_DAY) / MINUTES_IN_HOUR
        hoursDigit1.text = hoursDisplayValue.getDigit(1).toString()
        hoursDigit2.text = hoursDisplayValue.getDigit(0).toString()

        val minutesDisplayValue = totalMinutesLeft - daysDisplayValue * MINUTES_IN_DAY - hoursDisplayValue * MINUTES_IN_HOUR
        minutesDigit1.text = minutesDisplayValue.getDigit(1).toString()
        minutesDigit2.text = minutesDisplayValue.getDigit(0).toString()
    }

    private val binding = ViewTimerBinding.inflate(LayoutInflater.from(context))
}