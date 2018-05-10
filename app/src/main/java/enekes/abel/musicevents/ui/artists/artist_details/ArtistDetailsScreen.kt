package enekes.abel.musicevents.ui.artists.artist_details

import enekes.abel.musicevents.model.Artist
import enekes.abel.musicevents.model.Event

interface ArtistDetailsScreen {
    fun showArtist(artist: Artist)
    fun showArtistEvents(events: List<Event>)
}