package enekes.abel.musicevents.ui.utils

import android.support.v7.widget.RecyclerView
import com.android.databinding.library.baseAdapters.BR


class BoundViewHolder(private val binding: android.databinding.ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(obj: Any) {
        binding.setVariable(BR.obj, obj)
        binding.executePendingBindings()
    }
}