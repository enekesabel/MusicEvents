package enekes.abel.musicevents.ui.artists.artist_details

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import enekes.abel.musicevents.MusicEventsApplication
import enekes.abel.musicevents.R
import enekes.abel.musicevents.databinding.ActivityArtistDetailsBinding
import enekes.abel.musicevents.model.Artist
import enekes.abel.musicevents.model.Event
import enekes.abel.musicevents.ui.events.ArtistDetailsEventRecyclerViewAdapter
import enekes.abel.musicevents.ui.main.MainActivity
import enekes.abel.musicevents.ui.utils.ArtistImageLoader
import kotlinx.android.synthetic.main.activity_artist_details.*
import kotlinx.android.synthetic.main.content_artist_details.*
import javax.inject.Inject

class ArtistDetailsActivity : AppCompatActivity(), ArtistDetailsScreen {
    @Inject
    lateinit var artistDetailsPresenter: ArtistDetailsPresenter

    private lateinit var binding: ActivityArtistDetailsBinding
    private lateinit var artistImageLoader: ArtistImageLoader

    private fun loadArtistImage(artist: Artist) {
        artistImageLoader.loadImage(artist, artistImage)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MusicEventsApplication.injector.inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist_details)
        setSupportActionBar(toolbar)
        binding.presenter = artistDetailsPresenter
        binding.layoutManager = LinearLayoutManager(this)
        artistImageLoader = ArtistImageLoader(this)
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
        binding.eventsAdapter = ArtistDetailsEventRecyclerViewAdapter(events)
    }

}
