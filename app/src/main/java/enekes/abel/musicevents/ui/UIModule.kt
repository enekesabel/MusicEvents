package enekes.abel.musicevents.ui

import android.content.Context
import dagger.Module
import dagger.Provides
import enekes.abel.musicevents.ui.artists.ArtistsPresenter
import enekes.abel.musicevents.ui.main.MainPresenter
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    @Singleton
    fun provideMainPresenter(): MainPresenter {
        return MainPresenter()
    }

    @Provides
    @Singleton
    fun provideArtistPresenter(): ArtistsPresenter {
        return ArtistsPresenter()
    }

}