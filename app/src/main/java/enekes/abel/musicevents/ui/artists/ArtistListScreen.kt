package enekes.abel.musicevents.ui.artists

import enekes.abel.musicevents.model.Artist

interface ArtistListScreen{
    fun showArtist(artistName: String)

    fun showArtistList(artists: List<Artist>)
}