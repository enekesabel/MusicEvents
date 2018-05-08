package enekes.abel.musicevents.ui.utils

import android.support.v7.widget.RecyclerView
import com.android.databinding.library.baseAdapters.BR


class BoundViewHolder(private val binding: android.databinding.ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    lateinit var boundObject: Any
        private set

    fun bind(obj: Any, clickListener: OnBoundItemClickListener? = null) {
        boundObject = obj
        binding.setVariable(BR.obj, obj)
        if (clickListener != null) {
            binding.setVariable(BR.clickListener, clickListener)
        }
        binding.executePendingBindings()
    }
}