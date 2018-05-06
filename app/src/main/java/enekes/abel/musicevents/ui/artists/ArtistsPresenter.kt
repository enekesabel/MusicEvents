package enekes.abel.musicevents.ui.artists

import enekes.abel.musicevents.MusicEventsApplication
import enekes.abel.musicevents.interactor.artist.ArtistsInteractor
import enekes.abel.musicevents.ui.Presenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ArtistsPresenter : Presenter<ArtistsScreen>() {

    @Inject
    lateinit var artistsInteractor: ArtistsInteractor

    override fun attachScreen(screen: ArtistsScreen) {
        super.attachScreen(screen)
        MusicEventsApplication.injector.inject(this)
    }

    fun getArtists() {
        artistsInteractor.getFavouriteArtists().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ artists ->
                    screen!!.showFavouriteArtists(artists)
                })
    }

}