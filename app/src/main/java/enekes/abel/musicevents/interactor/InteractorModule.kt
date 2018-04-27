package enekes.abel.musicevents.interactor

import dagger.Module
import dagger.Provides
import enekes.abel.musicevents.interactor.artist.ArtistsInteractor

@Module
class InteractorModule {
    @Provides
    fun provideArtistsInteractor(): ArtistsInteractor {
        return ArtistsInteractor()
    }
}