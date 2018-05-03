package enekes.abel.musicevents.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import enekes.abel.musicevents.MusicEventsApplication
import enekes.abel.musicevents.R
import enekes.abel.musicevents.databinding.ActivityMainBinding
import javax.inject.Inject

import kotlinx.android.synthetic.main.activity_main.*
import com.miguelcatalan.materialsearchview.MaterialSearchView
import enekes.abel.musicevents.network.model.artist_search.ArtistSearchEntry


class MainActivity : AppCompatActivity(), MainScreen {

    @Inject
    lateinit var mainPresenter: MainPresenter

    private lateinit var searchView: MaterialSearchView

    private fun initializeSearchView() {
        searchView = search_view as MaterialSearchView
        searchView.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                //Do some magic
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                mainPresenter.searchArtist(newText)
                return false
            }
        })

        searchView.setOnSearchViewListener(object : MaterialSearchView.SearchViewListener {
            override fun onSearchViewShown() {
                //Do some magic
            }

            override fun onSearchViewClosed() {
                //Do some magic
            }
        })
    }

    private fun setSearchViewSuggestions(suggestions: Array<String>) {
        searchView.setSuggestions(suggestions)
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


    override fun showArtistResults(artists: List<ArtistSearchEntry>) {
        val artistNames: Array<String> = artists.map { artist ->artist.name }.toTypedArray()
        setSearchViewSuggestions(artistNames)
    }

}
