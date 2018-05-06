package enekes.abel.musicevents

import com.orm.SugarApp
import enekes.abel.musicevents.ui.UIModule

class MusicEventsApplication : SugarApp() {
    companion object {
        @JvmStatic
        lateinit var injector: MusicEventsApplicationComponent

        @JvmStatic
        val IMAGE_DIR: String = "imageDir"
    }

    override fun onCreate() {
        super.onCreate()

        injector = DaggerMusicEventsApplicationComponent.builder().uIModule(
                UIModule(this)
        ).build()

    }
}