package enekes.abel.musicevents.ui.main

import enekes.abel.musicevents.model.Artist
import enekes.abel.musicevents.network.model.artist_search.ArtistSearchEntry
import enekes.abel.musicevents.ui.artists.ArtistsScreen

/**
 * Created by mobsoft on 2018. 03. 23..
 */
interface MainScreen: ArtistsScreen {
    fun showEvents(artistName: String)

    fun showArtist(artistName: String)

    fun showArtistResults(artists: List<ArtistSearchEntry>)
}