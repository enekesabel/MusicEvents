package enekes.abel.musicevents.ui.artists.artist_details

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import enekes.abel.musicevents.MusicEventsApplication
import enekes.abel.musicevents.R
import enekes.abel.musicevents.databinding.ActivityArtistDetailsBinding
import enekes.abel.musicevents.model.Artist
import enekes.abel.musicevents.model.Event
import enekes.abel.musicevents.ui.events.EventRecyclerViewAdapter
import enekes.abel.musicevents.ui.main.MainActivity

import kotlinx.android.synthetic.main.activity_artist_details.*
import kotlinx.android.synthetic.main.content_artist_details.*
import javax.inject.Inject
import android.graphics.drawable.Drawable
import android.graphics.Bitmap
import android.content.ContextWrapper
import com.squareup.picasso.Target
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.lang.Exception




class ArtistDetailsActivity : AppCompatActivity(), ArtistDetailsScreen {
    @Inject
    lateinit var artistDetailsPresenter: ArtistDetailsPresenter

    private lateinit var binding: ActivityArtistDetailsBinding

    private fun picassoImageTarget(context: Context, imageDir: String, imageName: String): com.squareup.picasso.Target {
        val cw = ContextWrapper(context)
        val directory = cw.getDir(imageDir, Context.MODE_PRIVATE) // path to /data/data/yourapp/app_imageDir
        return object : Target {

            override fun onBitmapLoaded(bitmap: Bitmap, from: Picasso.LoadedFrom) {
                Thread(Runnable {
                    val myImageFile = File(directory, imageName) // Create image file
                    var fos: FileOutputStream? = null
                    try {
                        fos = FileOutputStream(myImageFile)
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)
                    } catch (e: IOException) {
                        e.printStackTrace()
                    } finally {
                        try {
                            fos!!.close()
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }

                    }
                }).start()
            }

            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {}
            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                if (placeHolderDrawable != null) {
                }
            }
        }
    }

    private fun loadArtistImage(artist: Artist) {
        val imageName = artist.artistId.toString() + ".jpeg"

        // load image from storage if already downloaded
        artist.imageFile?.let {
            val cw = ContextWrapper(applicationContext)
            val directory = cw.getDir("imageDir", Context.MODE_PRIVATE)
            val myImageFile = File(directory, imageName)
            Picasso.get().load(myImageFile).into(artistImage)
        } ?: run {
            // if not downloaded yet, download & save
            val target = picassoImageTarget(applicationContext, "imageDir", imageName)
            Picasso.get().load(artist.imageUrl).into(target)
            artist.imageFile = imageName
            artist.save()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MusicEventsApplication.injector.inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist_details)
        setSupportActionBar(toolbar)
        binding.presenter = artistDetailsPresenter
        binding.layoutManager = LinearLayoutManager(this)
    }

    override fun onStart() {
        super.onStart()
        artistDetailsPresenter.attachScreen(this)
        val artistName: String = this.intent.getStringExtra(MainActivity.ARTIST_KEY)
        artistDetailsPresenter.getArtist(artistName)
    }

    override fun onStop() {
        super.onStop()
        artistDetailsPresenter.detachScreen()
    }

    override fun showArtist(artist: Artist) {
        binding.artist = artist
        loadArtistImage(artist)
    }

    override fun showArtistEvents(events: List<Event>) {
        binding.eventsAdapter = EventRecyclerViewAdapter(events)
    }

}
