package enekes.abel.musicevents

import android.app.Application
import enekes.abel.musicevents.ui.UIModule

class MusicEventsApplication : Application() {
    companion object {
        @JvmStatic
        var injector: MusicEventsApplicationComponent? = null
    }


    override fun onCreate() {
        super.onCreate()

        injector = DaggerMusicEventsApplicationComponent.builder().uIModule(
                UIModule(this)
        ).build()
    }
}