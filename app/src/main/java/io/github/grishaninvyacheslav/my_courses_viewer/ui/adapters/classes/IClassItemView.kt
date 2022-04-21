package io.github.grishaninvyacheslav.my_courses_viewer.ui.adapters.classes

interface IClassItemView {
    var pos: Int
    fun setTitle(title: String)
    fun setTime(time: String)
    fun setIcon(id: Int)
}