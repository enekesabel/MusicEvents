package enekes.abel.musicevents.ui.events

import android.content.Context
import android.widget.ImageView
import enekes.abel.musicevents.R
import enekes.abel.musicevents.model.Event
import enekes.abel.musicevents.ui.utils.*


class EventRecyclerViewAdapter(
        private val mValues: List<Event>,
        context: Context,
        onBoundItemClickListener: OnBoundItemClickListener? = null)
    : SingleLayoutAdapter(R.layout.event_item, onBoundItemClickListener) {

    private val artistImageLoader: ArtistImageLoader = ArtistImageLoader(context)

    override fun onBindViewHolder(holder: BoundViewHolder,
                                  position: Int) {
        super.onBindViewHolder(holder, position)

        val imageView = holder.itemView.findViewById<ImageView>(R.id.artist_image)
        val artist = (holder.boundObject as Event).artist
        artist?.let { artistImageLoader.loadImage(it, imageView) }
    }
    override fun getItemCount(): Int = mValues.size

    override fun getObjForPosition(position: Int): Any {
        return mValues[position]
    }
}
