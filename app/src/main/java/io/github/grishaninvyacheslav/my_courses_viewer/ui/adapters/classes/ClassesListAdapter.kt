package io.github.grishaninvyacheslav.my_courses_viewer.ui.adapters.classes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.grishaninvyacheslav.my_courses_viewer.databinding.ItemClassBinding

class ClassesListAdapter(
    private val dataModel: IClassesDataModel,
    var onClassClick: ((view: IClassItemView) -> Unit),
    var onStripeClick: ((view: IClassItemView) -> Unit)
) :
    RecyclerView.Adapter<ClassViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ClassViewHolder(
            ItemClassBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onClassClick,
            onStripeClick
        )

    override fun getItemCount() = dataModel.getCount()

    override fun onBindViewHolder(holderMarker: ClassViewHolder, position: Int) =
        dataModel.bindView(holderMarker.apply { pos = position })
}