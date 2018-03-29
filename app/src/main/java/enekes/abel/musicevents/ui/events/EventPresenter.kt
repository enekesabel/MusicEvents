package enekes.abel.musicevents.ui.events

import enekes.abel.musicevents.MusicEventsApplication
import enekes.abel.musicevents.ui.Presenter

class EventPresenter : Presenter<EventsScreen>() {

    override fun attachScreen(screen: EventsScreen) {
        super.attachScreen(screen)
        MusicEventsApplication.injector?.inject(this)
    }

    override fun detachScreen() {
        super.detachScreen()
    }

}