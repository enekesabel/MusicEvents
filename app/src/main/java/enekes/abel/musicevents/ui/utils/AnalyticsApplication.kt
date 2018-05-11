package enekes.abel.musicevents.ui.utils

import com.google.android.gms.analytics.Tracker

interface AnalyticsApplication {
    fun getDefaultTracker(): Tracker
}