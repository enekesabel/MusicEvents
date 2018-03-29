package enekes.abel.musicevents.interactor

import dagger.Module
import dagger.Provides
import enekes.abel.musicevents.interactor.artist.ArtistsInteractor
import enekes.abel.musicevents.interactor.event.EventsInteractor

@Module
class InteractorModule {
    @Provides
    fun provideArtistsInteractor(): ArtistsInteractor {
        return ArtistsInteractor()
    }

    @Provides
    fun provideEventsInteractor(): EventsInteractor {
        return EventsInteractor()
    }
}