package enekes.abel.musicevents.ui.artists.artist_details

import enekes.abel.musicevents.model.Artist
import enekes.abel.musicevents.model.Event

/**
 * Created by mobsoft on 2018. 03. 23..
 */
interface ArtistDetailsScreen {
    fun showArtist(artist: Artist)
    fun showArtistEvents(events: List<Event>)
}