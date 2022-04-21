package io.github.grishaninvyacheslav.my_courses_viewer.ui.adapters.classes

interface IClassesDataModel {
    fun getCount(): Int
    fun bindView(view: IClassItemView)
}