package enekes.abel.musicevents.ui.main

import enekes.abel.musicevents.MusicEventsApplication
import enekes.abel.musicevents.interactor.artist.ArtistsInteractor
import enekes.abel.musicevents.ui.Presenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by mobsoft on 2018. 03. 23..
 */
class MainPresenter : Presenter<MainScreen>() {

    @Inject
    lateinit var artistInteractor: ArtistsInteractor

    override fun attachScreen(screen: MainScreen) {
        super.attachScreen(screen)
        MusicEventsApplication.injector.inject(this)
    }

    fun searchArtist(name: String) {
        if (name.isNotEmpty()) {
            artistInteractor.searchArtist(name)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe({ result ->
                        screen!!.showArtistResults(result)
                    }, { error ->
                        error.printStackTrace()
                    })
        }
    }

    fun getFavouriteArtists() {
        artistInteractor.getFavouriteArtists().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ artists ->
                    screen!!.showFavouriteArtists(artists)
                })
    }

}