package enekes.abel.musicevents.ui.events

import enekes.abel.musicevents.R
import enekes.abel.musicevents.model.Event
import enekes.abel.musicevents.ui.utils.SingleLayoutAdapter


class EventRecyclerViewAdapter(
        private val mValues: List<Event>)
    : SingleLayoutAdapter(R.layout.fragment_event) {

    override fun getItemCount(): Int = mValues.size

    override fun getObjForPosition(position: Int): Any {
        return mValues[position]
    }
}
