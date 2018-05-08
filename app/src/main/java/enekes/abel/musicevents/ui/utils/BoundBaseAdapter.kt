package enekes.abel.musicevents.ui.utils

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import android.support.v7.widget.RecyclerView


abstract class BoundBaseAdapter(private val clickListener: OnBoundItemClickListener? = null) : RecyclerView.Adapter<BoundViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): BoundViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
                layoutInflater, viewType, parent, false)
        return BoundViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BoundViewHolder,
                                  position: Int) {
        val obj = getObjForPosition(position)
        holder.bind(obj, clickListener)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    protected abstract fun getObjForPosition(position: Int): Any

    protected abstract fun getLayoutIdForPosition(position: Int): Int
}