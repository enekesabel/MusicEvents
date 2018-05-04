package enekes.abel.musicevents.ui.artists.artist_details

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import enekes.abel.musicevents.MusicEventsApplication
import enekes.abel.musicevents.R
import enekes.abel.musicevents.databinding.ActivityArtistDetailsBinding
import enekes.abel.musicevents.model.Artist
import enekes.abel.musicevents.ui.main.MainActivity

import kotlinx.android.synthetic.main.activity_artist_details.*
import javax.inject.Inject

class ArtistDetailsActivity : AppCompatActivity(), ArtistDetailsScreen {

    @Inject
    lateinit var artistDetailsPresenter: ArtistDetailsPresenter

    private lateinit var binding: ActivityArtistDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MusicEventsApplication.injector.inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist_details)
        setSupportActionBar(toolbar)
        binding.presenter = artistDetailsPresenter
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
    }


}
