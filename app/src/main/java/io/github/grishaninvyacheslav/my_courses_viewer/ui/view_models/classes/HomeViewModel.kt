package io.github.grishaninvyacheslav.my_courses_viewer.ui.view_models.classes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.grishaninvyacheslav.my_courses_viewer.models.classes.ITodayClassesRepository
import io.github.grishaninvyacheslav.my_courses_viewer.models.classes.TodayClassesRepositoryFake
import io.github.grishaninvyacheslav.my_courses_viewer.models.homeworks.HomeworksRepositoryFake
import io.github.grishaninvyacheslav.my_courses_viewer.models.homeworks.IHomeworksRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val classesRepository: ITodayClassesRepository = TodayClassesRepositoryFake(),
    private val homeworksRepository: IHomeworksRepository = HomeworksRepositoryFake()
) : ViewModel() {
    private val mutableClassesListState: MutableLiveData<ClassesListState> = MutableLiveData()
    private val mutableHomeworksListState: MutableLiveData<HomeworksListState> = MutableLiveData()

    val classesListState: LiveData<ClassesListState>
        get() {
            mutableClassesListState.value = ClassesListState.Loading
            viewModelScope.launch(Dispatchers.IO) {
                mutableClassesListState.postValue(ClassesListState.Ready(classesRepository.getTodayClasses()))
            }
            return mutableClassesListState
        }

    val homeworksListState: LiveData<HomeworksListState>
        get() {
            mutableHomeworksListState.value = HomeworksListState.Loading
            viewModelScope.launch(Dispatchers.IO) {
                mutableHomeworksListState.postValue(HomeworksListState.Ready(homeworksRepository.getHomeworks()))
            }
            return mutableHomeworksListState
        }
}