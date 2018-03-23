package enekes.abel.musicevents

import dagger.Component
import enekes.abel.musicevents.interactor.InteractorModule
import enekes.abel.musicevents.ui.UIModule
import enekes.abel.musicevents.ui.main.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(UIModule::class, InteractorModule::class))
interface MusicEventsApplicationComponent {
    fun inject(mainActivity: MainActivity)
}