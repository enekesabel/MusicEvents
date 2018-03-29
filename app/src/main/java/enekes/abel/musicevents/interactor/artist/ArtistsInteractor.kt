package enekes.abel.musicevents.interactor.artist

import enekes.abel.musicevents.MusicEventsApplication


public class ArtistsInteractor {

    fun ArtistsInteractor() {
        MusicEventsApplication.injector?.inject(this)
    }
}