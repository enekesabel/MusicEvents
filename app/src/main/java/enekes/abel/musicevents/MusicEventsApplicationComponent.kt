package enekes.abel.musicevents

import dagger.Component
import enekes.abel.musicevents.interactor.InteractorModule
import enekes.abel.musicevents.interactor.artist.ArtistsInteractor
import enekes.abel.musicevents.interactor.event.EventsInteractor
import enekes.abel.musicevents.network.NetworkModule
import enekes.abel.musicevents.ui.UIModule
import enekes.abel.musicevents.ui.artists.ArtistFragment
import enekes.abel.musicevents.ui.artists.ArtistsPresenter
import enekes.abel.musicevents.ui.artists.artist_details.ArtistDetailsPresenter
import enekes.abel.musicevents.ui.events.EventFragment
import enekes.abel.musicevents.ui.events.EventPresenter
import enekes.abel.musicevents.ui.main.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(UIModule::class, InteractorModule::class, NetworkModule::class))
interface MusicEventsApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(artistDetailsPresenter: ArtistDetailsPresenter)
    fun inject(artistsPresenter: ArtistsPresenter)
    fun inject(eventPresenter: EventPresenter)
    fun inject(artistsInteractor: ArtistsInteractor)
    fun inject(eventsInteractor: EventsInteractor)
    fun inject(artistFragment: ArtistFragment)
    fun inject(eventFragment: EventFragment)
}