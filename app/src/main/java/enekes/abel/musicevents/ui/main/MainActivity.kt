package enekes.abel.musicevents.ui.main

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import enekes.abel.musicevents.MusicEventsApplication
import enekes.abel.musicevents.R
import enekes.abel.musicevents.databinding.ActivityMainBinding
import javax.inject.Inject
import com.miguelcatalan.materialsearchview.MaterialSearchView
import com.miguelcatalan.materialsearchview.SearchAdapter
import enekes.abel.musicevents.model.Artist
import enekes.abel.musicevents.ui.artists.artist_details.ArtistDetailsActivity
import kotlinx.android.synthetic.main.activity_main.*
import enekes.abel.musicevents.ui.utils.Pager


class MainActivity : AppCompatActivity(),
        MainScreen,
        TabLayout.OnTabSelectedListener {
    @Inject
    lateinit var mainPresenter: MainPresenter

    private lateinit var searchView: MaterialSearchView
    private lateinit var binding: ActivityMainBinding
    private lateinit var searchAdapter: SearchAdapter

    companion object {
        val ARTIST_KEY = "ARTIST_KEY"
        val ARTIST_ID = "ARTIST_ID"
    }

    private fun initializeSearchView() {
        searchView = search_view as MaterialSearchView
        searchView.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (searchAdapter.count > 0) {
                    this@MainActivity.showArtistByName(searchAdapter.getItem(0) as String)
                }
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
            this.showArtistByName(item as String)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MusicEventsApplication.injector.inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val tab1 = tabLayout.newTab()
        val tab2 = tabLayout.newTab()
        tab1.text = getString(R.string.tab_1)
        tab2.text = getString(R.string.tab_2)
        tabLayout.addTab(tab1)
        tabLayout.addTab(tab2)
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = Pager(fragmentManager, tabLayout.tabCount)
        pager.adapter = adapter

        //Adding onTabSelectedListener to swipe views
        tabLayout.addOnTabSelectedListener(this)

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

    override fun showArtistById(artistId: Int) {
        searchView.closeSearch()
        val intent = Intent(this, ArtistDetailsActivity::class.java)
        intent.putExtra(ARTIST_ID, artistId)
        startActivity(intent)
    }


    override fun showArtistByName(artistName: String) {
        searchView.closeSearch()
        val intent = Intent(this, ArtistDetailsActivity::class.java)
        intent.putExtra(ARTIST_KEY, artistName)
        startActivity(intent)
    }

    override fun showArtistResults(artists: List<Artist>) {
        val artistNames: Array<String> = artists.map { artist -> artist.name!! }.toTypedArray()
        setSearchViewSuggestions(artistNames)
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {

    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        pager.currentItem = tab?.position ?: pager.currentItem
    }


}
