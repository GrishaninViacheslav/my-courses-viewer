package io.github.grishaninvyacheslav.my_courses_viewer.ui.adapters.homeworks

import androidx.recyclerview.widget.RecyclerView
import io.github.grishaninvyacheslav.my_courses_viewer.databinding.ItemHomeworkBinding

class HomeworkViewHolder(
    private val binding: ItemHomeworkBinding,
    private var onClassClick: ((view: IHomeworkItemView) -> Unit)?
) :
    RecyclerView.ViewHolder(binding.root),
    IHomeworkItemView {
    init {
        itemView.setOnClickListener { onClassClick?.invoke(this) }
    }

    override var pos = -1

    override fun setTitle(title: String) {
        binding.title.text = title
    }
}