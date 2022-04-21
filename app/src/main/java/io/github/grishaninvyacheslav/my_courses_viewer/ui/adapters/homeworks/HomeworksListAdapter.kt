package io.github.grishaninvyacheslav.my_courses_viewer.ui.adapters.homeworks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.grishaninvyacheslav.my_courses_viewer.databinding.ItemHomeworkBinding

class HomeworksListAdapter(
    private val dataModel: IHomeworksDataModel,
    var onItemClick: ((view: IHomeworkItemView) -> Unit)
) :
    RecyclerView.Adapter<HomeworkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HomeworkViewHolder(
            ItemHomeworkBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onItemClick,
        )

    override fun getItemCount() = dataModel.getCount()

    override fun onBindViewHolder(holderMarker: HomeworkViewHolder, position: Int) =
        dataModel.bindView(holderMarker.apply { pos = position })
}