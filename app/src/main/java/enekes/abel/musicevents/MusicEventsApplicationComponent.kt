package enekes.abel.musicevents

import android.databinding.ViewDataBinding
import dagger.Component
import enekes.abel.musicevents.interactor.InteractorModule
import enekes.abel.musicevents.interactor.artist.ArtistsInteractor
import enekes.abel.musicevents.network.NetworkModule
import enekes.abel.musicevents.ui.UIModule
import enekes.abel.musicevents.ui.artists.ArtistListFragment
import enekes.abel.musicevents.ui.artists.ArtistsPresenter
import enekes.abel.musicevents.ui.artists.artist_details.ArtistDetailsActivity
import enekes.abel.musicevents.ui.artists.artist_details.ArtistDetailsPresenter
import enekes.abel.musicevents.ui.events.EventListFragment
import enekes.abel.musicevents.ui.events.EventPresenter
import enekes.abel.musicevents.ui.main.MainActivity
import enekes.abel.musicevents.ui.main.MainPresenter
import enekes.abel.musicevents.ui.utils.AbstractBoundFragment
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(UIModule::class, InteractorModule::class, NetworkModule::class))
interface MusicEventsApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(artistDetailsActivity: ArtistDetailsActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(artistsPresenter: ArtistsPresenter)
    fun inject(eventPresenter: EventPresenter)
    fun inject(artistDetailsPresenter: ArtistDetailsPresenter)
    fun inject(artistsInteractor: ArtistsInteractor)
    fun inject(artistListFragment: ArtistListFragment)
    fun inject(abstractBoundFragment: AbstractBoundFragment<Any, ViewDataBinding>)
    fun inject(eventListFragment: EventListFragment)
}