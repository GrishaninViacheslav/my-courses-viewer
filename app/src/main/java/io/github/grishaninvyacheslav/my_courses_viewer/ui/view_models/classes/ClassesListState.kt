package io.github.grishaninvyacheslav.my_courses_viewer.ui.view_models.classes

import io.github.grishaninvyacheslav.my_courses_viewer.entities.ClassDto

sealed class ClassesListState {
    object Loading: ClassesListState()
    data class Ready(val classes: List<ClassDto>): ClassesListState()
}