package enekes.abel.musicevents.ui.artists

import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import enekes.abel.musicevents.MusicEventsApplication
import enekes.abel.musicevents.R
import enekes.abel.musicevents.model.Artist
import enekes.abel.musicevents.ui.utils.BoundViewHolder
import enekes.abel.musicevents.ui.utils.ImageManager
import enekes.abel.musicevents.ui.utils.SingleLayoutAdapter

class ArtistRecyclerViewAdapter(
        private val mValues: List<Artist>,
        context: Context)
    : SingleLayoutAdapter(R.layout.fragment_artist) {

    private val imageManager: ImageManager = ImageManager(context, MusicEventsApplication.IMAGE_DIR)

    override fun onBindViewHolder(holder: BoundViewHolder,
                                  position: Int) {
        super.onBindViewHolder(holder, position)

        val imageView = holder.itemView.findViewById<ImageView>(R.id.artist_image)
        val artist = holder.boundObject as Artist
        if (artist.imageFile != null) {
            imageManager.loadImageFromFile(artist.imageFile!!, imageView)
        }
    }

    override fun getItemCount(): Int = mValues.size

    override fun getObjForPosition(position: Int): Any {
        return mValues[position]
    }
}
