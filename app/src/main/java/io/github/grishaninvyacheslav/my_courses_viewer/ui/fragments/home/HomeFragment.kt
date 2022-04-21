package io.github.grishaninvyacheslav.my_courses_viewer.ui.fragments.home

import android.os.Bundle
import android.view.View
import io.github.grishaninvyacheslav.my_courses_viewer.databinding.FragmentHomeBinding
import io.github.grishaninvyacheslav.my_courses_viewer.ui.fragments.BaseFragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.grishaninvyacheslav.my_courses_viewer.entities.ClassDto
import io.github.grishaninvyacheslav.my_courses_viewer.entities.HomeworkDto
import io.github.grishaninvyacheslav.my_courses_viewer.ui.adapters.classes.ClassesListAdapter
import io.github.grishaninvyacheslav.my_courses_viewer.ui.adapters.classes.IClassItemView
import io.github.grishaninvyacheslav.my_courses_viewer.ui.adapters.classes.IClassesDataModel
import io.github.grishaninvyacheslav.my_courses_viewer.ui.adapters.homeworks.HomeworksListAdapter
import io.github.grishaninvyacheslav.my_courses_viewer.ui.adapters.homeworks.IHomeworkItemView
import io.github.grishaninvyacheslav.my_courses_viewer.ui.adapters.homeworks.IHomeworksDataModel
import io.github.grishaninvyacheslav.my_courses_viewer.ui.view_models.classes.ClassesListState
import io.github.grishaninvyacheslav.my_courses_viewer.ui.view_models.classes.HomeViewModel
import io.github.grishaninvyacheslav.my_courses_viewer.ui.view_models.classes.HomeworksListState

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.timer.setTime(2, 12, 35)
        viewModel.classesListState.observe(viewLifecycleOwner) {
            if (it is ClassesListState.Ready) {
                initClassesList(it.classes)
            }
        }
        viewModel.homeworksListState.observe(viewLifecycleOwner) {
            if (it is HomeworksListState.Ready) {
                initHomeworksList(it.homeworks)
            }
        }
    }

    private fun initClassesList(classes: List<ClassDto>) = with(binding) {
        classesList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        classesAdapter = ClassesListAdapter(
            classesDataModel.apply {
                this.classes = classes
            },
            onClassClick = { view -> /* TODO("NOT YET IMPLEMENTED") */ },
            onStripeClick = { view -> /* TODO("NOT YET IMPLEMENTED") */ }
        )
        classesList.adapter = classesAdapter
    }

    private fun initHomeworksList(homeworks: List<HomeworkDto>) = with(binding) {
        homeworkList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        homeworksAdapter = HomeworksListAdapter(
            homeworksDataModel.apply {
                this.homeworks = homeworks
            },
            onItemClick = { view -> /* TODO("NOT YET IMPLEMENTED") */ }
        )
        homeworkList.adapter = homeworksAdapter
    }

    private val classesDataModel = object : IClassesDataModel {
        var classes = listOf<ClassDto>()
        override fun getCount() = classes.size
        override fun bindView(view: IClassItemView) = with(classes[view.pos]) {
            view.setTitle(title)
        }
    }

    private val homeworksDataModel = object : IHomeworksDataModel {
        var homeworks = listOf<HomeworkDto>()
        override fun getCount() = homeworks.size
        override fun bindView(view: IHomeworkItemView) = with(homeworks[view.pos]) {
            view.setTitle(title)
        }
    }

    private var classesAdapter: ClassesListAdapter? = null
    private var homeworksAdapter: HomeworksListAdapter? = null
    private val viewModel: HomeViewModel by viewModels()
}