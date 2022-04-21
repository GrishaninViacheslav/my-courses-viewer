package io.github.grishaninvyacheslav.my_courses_viewer.models.classes

import io.github.grishaninvyacheslav.my_courses_viewer.entities.ClassDto

interface ITodayClassesRepository {
    suspend fun getTodayClasses(): List<ClassDto>
}