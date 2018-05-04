package enekes.abel.musicevents.ui.artists.artist_details

import enekes.abel.musicevents.MusicEventsApplication
import enekes.abel.musicevents.interactor.artist.ArtistsInteractor
import enekes.abel.musicevents.ui.Presenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ArtistDetailsPresenter : Presenter<ArtistDetailsScreen>() {

    @Inject
    lateinit var artistsInteractor: ArtistsInteractor

    override fun attachScreen(screen: ArtistDetailsScreen) {
        super.attachScreen(screen)
        MusicEventsApplication.injector.inject(this)
    }

    fun getArtist(artistName: String) {
        artistsInteractor.getArtist(artistName) .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    screen!!.showArtist(result)
                }, { error ->
                    error.printStackTrace()
                })
    }

}