package enekes.abel.musicevents.ui.artists

import android.content.Context
import android.widget.ImageView
import enekes.abel.musicevents.R
import enekes.abel.musicevents.model.Artist
import enekes.abel.musicevents.ui.utils.ArtistImageLoader
import enekes.abel.musicevents.ui.utils.BoundViewHolder
import enekes.abel.musicevents.ui.utils.OnBoundItemClickListener
import enekes.abel.musicevents.ui.utils.SingleLayoutAdapter

class ArtistRecyclerViewAdapter(
        private val mValues: List<Artist>,
        context: Context,
        onBoundItemClickListener: OnBoundItemClickListener? = null)
    : SingleLayoutAdapter(R.layout.artist_list_item, onBoundItemClickListener) {

    private val artistImageLoader: ArtistImageLoader = ArtistImageLoader(context)

    override fun onBindViewHolder(holder: BoundViewHolder,
                                  position: Int) {
        super.onBindViewHolder(holder, position)

        val imageView = holder.itemView.findViewById<ImageView>(R.id.artist_image)
        val artist = holder.boundObject as Artist
        artistImageLoader.loadImage(artist, imageView)

    }

    override fun getItemCount(): Int = mValues.size

    override fun getObjForPosition(position: Int): Any {
        return mValues[position]
    }
}
