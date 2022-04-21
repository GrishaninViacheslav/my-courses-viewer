package io.github.grishaninvyacheslav.my_courses_viewer.ui.adapters.homeworks

interface IHomeworksDataModel {
    fun getCount(): Int
    fun bindView(view: IHomeworkItemView)
}