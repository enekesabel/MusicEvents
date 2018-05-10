package enekes.abel.musicevents.interactor.event

import com.orm.SugarRecord
import enekes.abel.musicevents.model.Event
import io.reactivex.Observable

class EventInteractor {
    fun getFavouriteEvents(): Observable<List<Event>> {
        return Observable.create { subscriber ->
            val favouriteArtists = SugarRecord.find(Event::class.java, "favourite = ?", "1")
            subscriber.onNext(favouriteArtists)
        }
    }
}