package enekes.abel.musicevents.ui.events

import enekes.abel.musicevents.MusicEventsApplication
import enekes.abel.musicevents.interactor.event.EventInteractor
import enekes.abel.musicevents.ui.Presenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class EventPresenter : Presenter<EventListScreen>() {

    @Inject
    lateinit var eventInteractor: EventInteractor

    override fun attachScreen(screen: EventListScreen) {
        super.attachScreen(screen)
        MusicEventsApplication.injector.inject(this)
    }

    fun getEvents() {
        eventInteractor.getFavouriteEvents().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ events ->
                    screen!!.showEventList(events)
                })
    }

}