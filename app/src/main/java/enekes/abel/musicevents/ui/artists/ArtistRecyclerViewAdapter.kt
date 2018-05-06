package enekes.abel.musicevents.ui.artists

import enekes.abel.musicevents.R
import enekes.abel.musicevents.model.Artist
import enekes.abel.musicevents.ui.utils.SingleLayoutAdapter

class ArtistRecyclerViewAdapter(
        private val mValues: List<Artist>)
    : SingleLayoutAdapter(R.layout.fragment_artist) {

    override fun getItemCount(): Int = mValues.size

    override fun getObjForPosition(position: Int): Any {
        return mValues[position]
    }
}
