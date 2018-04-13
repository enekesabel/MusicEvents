package enekes.abel.musicevents.interactor.artist

import enekes.abel.musicevents.MusicEventsApplication
import enekes.abel.musicevents.network.NetworkConfig
import enekes.abel.musicevents.network.api.ArtistEventsApi
import enekes.abel.musicevents.network.api.ArtistInformationApi
import enekes.abel.musicevents.network.model.ArtistData
import enekes.abel.musicevents.network.model.EventData
import io.reactivex.Observable
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


public class ArtistsInteractor {

    @Inject
    lateinit var artistInformationApi: ArtistInformationApi

    @Inject
    lateinit var artistEventsApi: ArtistEventsApi

    init {
        MusicEventsApplication.injector.inject(this)
    }

    fun getArtist(artistName: String): Observable<ArtistData> {
        return Observable.create { subscriber ->

            val response = this.artistInformationApi.artist(artistName, NetworkConfig.APP_KEY).execute()

            if (response.isSuccessful) {
                val artistData = response.body()
                subscriber.onNext(artistData!!)
                subscriber.onComplete()
            } else {
                subscriber.onError(Throwable(response.message()))
            }

        }
    }

    fun getArtistEvents(artistName: String): Observable<List<EventData>> {
        return Observable.create { subscriber ->

            val date = SimpleDateFormat("yyyy-MM-dd").format(Date())

            val response = this.artistEventsApi.artistEvents(artistName, NetworkConfig.APP_KEY, date).execute()

            if (response.isSuccessful) {
                val eventData = response.body()
                subscriber.onNext(eventData!!)
                subscriber.onComplete()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }

}