package enekes.abel.musicevents.interactor.event

import enekes.abel.musicevents.MusicEventsApplication


public class EventsInteractor {

    fun EventsInteractor() {
        MusicEventsApplication.injector.inject(this)
    }
}