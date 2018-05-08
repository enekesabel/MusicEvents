package enekes.abel.musicevents.ui.utils

abstract class SingleLayoutAdapter(private val layoutId: Int, onBoundItemClickListener: OnBoundItemClickListener? = null) : BoundBaseAdapter(onBoundItemClickListener) {

    override fun getLayoutIdForPosition(position: Int): Int {
        return layoutId
    }
}