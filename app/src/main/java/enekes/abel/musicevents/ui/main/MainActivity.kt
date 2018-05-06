package enekes.abel.musicevents.ui.main

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import enekes.abel.musicevents.MusicEventsApplication
import enekes.abel.musicevents.R
import enekes.abel.musicevents.databinding.ActivityMainBinding
import javax.inject.Inject
import com.miguelcatalan.materialsearchview.MaterialSearchView
import com.miguelcatalan.materialsearchview.SearchAdapter
import enekes.abel.musicevents.R.id.search_view
import enekes.abel.musicevents.model.Artist
import enekes.abel.musicevents.network.model.artist_search.ArtistSearchEntry
import enekes.abel.musicevents.ui.artists.ArtistRecyclerViewAdapter
import enekes.abel.musicevents.ui.artists.artist_details.ArtistDetailsActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainScreen {
    @Inject
    lateinit var mainPresenter: MainPresenter

    private lateinit var searchView: MaterialSearchView
    private lateinit var binding: ActivityMainBinding
    private lateinit var searchAdapter: SearchAdapter

    companion object {
        val ARTIST_KEY = "ARTIST_KEY"
    }

    private fun initializeSearchView() {
        searchView = search_view as MaterialSearchView
        searchView.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                showArtist(searchAdapter.getItem(0) as String)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                mainPresenter.searchArtist(newText)
                return false
            }
        })
    }

    private fun setSearchViewSuggestions(suggestions: Array<String>) {
        // searchView.setSuggestions(suggestions)

        searchAdapter = SearchAdapter(this, suggestions)
        searchView.setAdapter(searchAdapter)
        searchView.setOnItemClickListener({ parent, view, position, id ->
            val item = parent.adapter.getItem(position)
            showArtist(item as String)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MusicEventsApplication.injector.inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

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
        mainPresenter.getFavouriteArtists()
    }

    override fun onStop() {
        super.onStop()
        mainPresenter.detachScreen()
    }


    override fun showEvents(artistName: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showArtist(artistName: String) {
        searchView.closeSearch()
        val intent = Intent(this, ArtistDetailsActivity::class.java)
        intent.putExtra(ARTIST_KEY, artistName)
        startActivity(intent)
    }

    override fun showArtistResults(artists: List<ArtistSearchEntry>) {
        val artistNames: Array<String> = artists.map { artist -> artist.name }.toTypedArray()
        setSearchViewSuggestions(artistNames)
    }

    override fun showFavouriteArtists(artists: List<Artist>) {
        binding.artistsAdapter = ArtistRecyclerViewAdapter(artists, applicationContext)
    }

}
