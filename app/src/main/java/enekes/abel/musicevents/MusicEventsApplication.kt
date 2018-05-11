package enekes.abel.musicevents

import com.orm.SugarApp
import enekes.abel.musicevents.ui.UIModule
import com.google.android.gms.analytics.GoogleAnalytics
import com.google.android.gms.analytics.Tracker
import android.R.xml
import enekes.abel.musicevents.ui.utils.AnalyticsApplication


class MusicEventsApplication : SugarApp(), AnalyticsApplication {
    companion object {
        @JvmStatic
        lateinit var injector: MusicEventsApplicationComponent

        @JvmStatic
        val IMAGE_DIR: String = "imageDir"

        private lateinit var sAnalytics: GoogleAnalytics
        private var sTracker: Tracker? = null
    }

    override fun onCreate() {
        super.onCreate()

        injector = DaggerMusicEventsApplicationComponent.builder().uIModule(
                UIModule(this)
        ).build()

        sAnalytics = GoogleAnalytics.getInstance(this)
    }

    @Synchronized
    override fun getDefaultTracker(): Tracker {
        // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
        if (sTracker == null) {
            sTracker = sAnalytics.newTracker(R.xml.global_tracker)
        }

        return MusicEventsApplication.sTracker!!
    }
}