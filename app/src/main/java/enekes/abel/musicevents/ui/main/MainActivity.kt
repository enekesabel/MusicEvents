package enekes.abel.musicevents.ui.main

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.widget.AdapterView
import android.widget.ListAdapter
import enekes.abel.musicevents.MusicEventsApplication
import enekes.abel.musicevents.R
import enekes.abel.musicevents.databinding.ActivityMainBinding
import javax.inject.Inject

import kotlinx.android.synthetic.main.activity_main.*
import com.miguelcatalan.materialsearchview.MaterialSearchView
import enekes.abel.musicevents.network.model.artist_search.ArtistSearchEntry
import enekes.abel.musicevents.ui.artists.artist_details.ArtistDetailsActivity


class MainActivity : AppCompatActivity(), MainScreen {

    @Inject
    lateinit var mainPresenter: MainPresenter

    private lateinit var searchView: MaterialSearchView

    private companion object {
        val ARTIST_KEY = "ARTIST_KEY"
        var firstSuggestion = ""
    }

    private fun initializeSearchView() {
        searchView = search_view as MaterialSearchView
        searchView.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                showArtist(firstSuggestion)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                mainPresenter.searchArtist(newText)
                return false
            }
        })
    }

    private fun setSearchViewSuggestions(suggestions: Array<String>) {
        firstSuggestion = suggestions[0]
        searchView.setSuggestions(suggestions)
        searchView.setOnItemClickListener({ parent, view, position, id ->
            showArtist(suggestions[position])
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MusicEventsApplication.injector.inject(this)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(toolbar)
        initializeSearchView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_events, menu)

        val item = menu.findItem(R.id.action_search)
        val searchView = search_view as MaterialSearchView
        searchView.setMenuItem(item)

        return true
    }

    override fun onStart() {
        super.onStart()
        mainPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        mainPresenter.detachScreen()
    }


    override fun showEvents(artistName: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showArtist(artistName: String) {
        val intent = Intent(this, ArtistDetailsActivity::class.java)
        intent.putExtra(ARTIST_KEY, artistName)
        startActivity(intent)
    }

    override fun showArtistResults(artists: List<ArtistSearchEntry>) {
        val artistNames: Array<String> = artists.map { artist -> artist.name }.toTypedArray()
        setSearchViewSuggestions(artistNames)
    }

}
