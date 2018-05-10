package enekes.abel.musicevents.ui.utils

import android.content.Context
import android.widget.ImageView
import com.squareup.picasso.Callback
import enekes.abel.musicevents.MusicEventsApplication
import enekes.abel.musicevents.model.Artist
import java.lang.Exception

class ArtistImageLoader(context: Context) {

    private val imageManager: ImageManager = ImageManager(context, MusicEventsApplication.IMAGE_DIR)

    fun loadImage(artist: Artist, imageView: ImageView) {
        val imageName = artist.artistId.toString() + ".jpeg"

        // load image from storage if already downloaded
        artist.imageFile?.let {
            imageManager.loadImageFromFile(imageName, imageView, object : Callback {
                override fun onSuccess() {
                }

                override fun onError(e: Exception?) {
                    downloadAndSave(artist, imageName, imageView)
                    e?.printStackTrace()
                }
            })
        } ?: run {
            // if not downloaded yet, download & save
            downloadAndSave(artist, imageName, imageView)
        }
    }

    private fun downloadAndSave(artist: Artist, imageName:String, imageView:ImageView){
        imageManager.downloadAndSave(artist.imageUrl!!, imageName, object : Callback {
            override fun onSuccess() {
                artist.imageFile = imageName
                artist.save()
                imageManager.loadImageFromFile(imageName, imageView, object : Callback {
                    override fun onSuccess() {
                    }

                    override fun onError(e: Exception?) {
                        e?.printStackTrace()
                    }
                })
            }

            override fun onError(e: Exception?) {
                e?.printStackTrace()
            }
        })

    }

}