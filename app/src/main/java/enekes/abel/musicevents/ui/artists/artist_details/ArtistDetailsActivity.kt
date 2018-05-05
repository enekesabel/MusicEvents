package enekes.abel.musicevents.ui.artists.artist_details

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

class ArtistDetailsActivity : AppCompatActivity(), ArtistDetailsScreen {
    @Inject
    lateinit var artistDetailsPresenter: ArtistDetailsPresenter

    private lateinit var binding: ActivityArtistDetailsBinding

    private fun loadArtistImage(artist: Artist) {
        artist.imageFile?.let {
            Picasso.get().load(it).into(artistImage)
        } ?: run {
            Picasso.get().load(artist.imageUrl).into(artistImage)
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
