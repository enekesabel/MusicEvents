package enekes.abel.musicevents.ui.main

import enekes.abel.musicevents.model.Artist

/**
 * Created by mobsoft on 2018. 03. 23..
 */
interface MainScreen : ArtistDetailsOpener {
    fun showArtistResults(artists: List<Artist>)
}