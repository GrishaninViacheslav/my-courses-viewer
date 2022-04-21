package io.github.grishaninvyacheslav.my_courses_viewer.ui.view_models.classes

import io.github.grishaninvyacheslav.my_courses_viewer.entities.HomeworkDto

sealed class HomeworksListState {
    object Loading: HomeworksListState()
    data class Ready(val homeworks: List<HomeworkDto>): HomeworksListState()
}