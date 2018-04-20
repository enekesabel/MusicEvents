package enekes.abel.musicevents.mock

import enekes.abel.musicevents.model.Artist

class MockArtistRepository : MockSugarRepository<Artist>() {

    fun create(): Artist {
        return super.create(Artist::class.java)
    }
}