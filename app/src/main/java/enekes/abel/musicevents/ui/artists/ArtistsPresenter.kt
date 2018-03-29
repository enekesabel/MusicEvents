package enekes.abel.musicevents.ui.artists

import enekes.abel.musicevents.MusicEventsApplication
import enekes.abel.musicevents.ui.Presenter
import enekes.abel.musicevents.ui.artists.ArtistsScreen

class ArtistsPresenter : Presenter<ArtistsScreen>() {

    override fun attachScreen(screen: ArtistsScreen) {
        super.attachScreen(screen)
        MusicEventsApplication.injector?.inject(this)
    }

    override fun detachScreen() {
        super.detachScreen()
    }

}