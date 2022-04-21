package io.github.grishaninvyacheslav.my_courses_viewer.utils

import kotlin.math.pow

fun Int.getDigit(digitPosition: Int) = (this / 10f.pow(digitPosition) % 10).toInt()