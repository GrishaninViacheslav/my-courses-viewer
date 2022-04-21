package io.github.grishaninvyacheslav.my_courses_viewer.ui.adapters.classes

import androidx.recyclerview.widget.RecyclerView
import io.github.grishaninvyacheslav.my_courses_viewer.databinding.ItemClassBinding

class ClassViewHolder(
    private val binding: ItemClassBinding,
    private var onClassClick: ((view: IClassItemView) -> Unit)?,
    private var onStripeClick: ((view: IClassItemView) -> Unit)?
) :
    RecyclerView.ViewHolder(binding.root),
    IClassItemView {
    init {
        itemView.setOnClickListener { onClassClick?.invoke(this) }
        binding.title.setOnClickListener { onStripeClick?.invoke(this) }
    }

    override var pos = -1

    override fun setTitle(title: String) {
        binding.title.text = title
    }

    override fun setTime(time: String) {
        TODO("Not yet implemented")
    }

    override fun setIcon(id: Int) {
        TODO("Not yet implemented")
    }
}