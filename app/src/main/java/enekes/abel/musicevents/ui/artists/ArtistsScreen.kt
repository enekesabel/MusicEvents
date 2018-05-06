package enekes.abel.musicevents.ui.artists

import enekes.abel.musicevents.model.Artist

interface ArtistsScreen {
    fun showFavouriteArtists(artists: List<Artist>)
}