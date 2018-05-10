package enekes.abel.musicevents.ui.artists

import enekes.abel.musicevents.model.Artist

interface ArtistScreen {
    fun showArtist(artist: List<Artist>)
}