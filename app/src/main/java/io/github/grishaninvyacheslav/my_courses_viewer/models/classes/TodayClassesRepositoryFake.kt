package io.github.grishaninvyacheslav.my_courses_viewer.models.classes

import io.github.grishaninvyacheslav.my_courses_viewer.entities.ClassDto

class TodayClassesRepositoryFake : ITodayClassesRepository {
    private val todayClasses = listOf(
        ClassDto("History", "8:00 - 8:45", 0),
        ClassDto("Economics", "9:00 - 9:45", 0),
        ClassDto("Calculus", "10:00 - 11:45", 0),
        ClassDto("Physics", "12:00 - 12:45", 0),
        ClassDto("Literature", "13:00 - 13:45", 0),
        ClassDto("Physical Education", "14:00 - 14:35", 0)
    )

    override suspend fun getTodayClasses(): List<ClassDto> {
        return todayClasses
    }
}