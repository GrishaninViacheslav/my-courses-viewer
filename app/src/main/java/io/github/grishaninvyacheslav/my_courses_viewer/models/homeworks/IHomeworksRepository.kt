package io.github.grishaninvyacheslav.my_courses_viewer.models.homeworks

import io.github.grishaninvyacheslav.my_courses_viewer.entities.HomeworkDto

interface IHomeworksRepository {
    suspend fun getHomeworks(): List<HomeworkDto>
}