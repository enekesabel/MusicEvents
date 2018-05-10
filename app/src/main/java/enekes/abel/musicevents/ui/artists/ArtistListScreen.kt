package enekes.abel.musicevents.ui.artists

import enekes.abel.musicevents.model.Artist
import enekes.abel.musicevents.ui.main.ArtistDetailsOpener

interface ArtistListScreen : ArtistDetailsOpener {

    fun showArtistList(artists: List<Artist>)
}