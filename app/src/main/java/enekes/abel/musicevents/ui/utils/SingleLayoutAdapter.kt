package enekes.abel.musicevents.ui.utils

abstract class SingleLayoutAdapter(private val layoutId: Int) : BoundBaseAdapter() {

    override fun getLayoutIdForPosition(position: Int): Int {
        return layoutId
    }
}