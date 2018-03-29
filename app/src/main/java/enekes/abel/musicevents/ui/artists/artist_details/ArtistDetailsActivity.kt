package enekes.abel.musicevents.ui.artists.artist_details

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import enekes.abel.musicevents.R

import kotlinx.android.synthetic.main.activity_artist_details.*

class ArtistDetailsActivity : AppCompatActivity(), ArtistDetailsScreen {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_details)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun showArtist() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
