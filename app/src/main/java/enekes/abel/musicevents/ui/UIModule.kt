package enekes.abel.musicevents.ui

import android.content.Context
import dagger.Module
import dagger.Provides
import enekes.abel.musicevents.ui.main.MainPresenter
import javax.inject.Singleton

@Module
class UIModule(context: Context) {
    private val context: Context = context;

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    @Singleton
    fun provideMainPresenter(): MainPresenter {
        return MainPresenter()
    }

}