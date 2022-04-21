package io.github.grishaninvyacheslav.my_courses_viewer.models.homeworks

import io.github.grishaninvyacheslav.my_courses_viewer.entities.HomeworkDto

class HomeworksRepositoryFake : IHomeworksRepository {
    private val currentHomeworks = listOf(
        HomeworkDto("History"),
        HomeworkDto("Economics"),
        HomeworkDto("Calculus"),
        HomeworkDto("Physics"),
        HomeworkDto("Literature"),
        HomeworkDto("Physical Education")
    )

    override suspend fun getHomeworks(): List<HomeworkDto> {
        return currentHomeworks
    }
}