package enekes.abel.musicevents.ui.artists

import enekes.abel.musicevents.MusicEventsApplication
import enekes.abel.musicevents.interactor.artist.ArtistsInteractor
import enekes.abel.musicevents.network.model.ArtistData
import enekes.abel.musicevents.ui.Presenter
import javax.inject.Inject

class ArtistsPresenter : Presenter<ArtistsScreen>() {

    @Inject
    lateinit var artistsInteractor: ArtistsInteractor

    override fun attachScreen(screen: ArtistsScreen) {
        super.attachScreen(screen)
        MusicEventsApplication.injector.inject(this)
    }

    override fun detachScreen() {
        super.detachScreen()
    }

    fun getArtist(artistName: String) {
        val observable = this.artistsInteractor.getArtist(artistName)
        observable.subscribe({ artistData: ArtistData? ->
            System.out.println(artistData.toString())
        })
    }

}