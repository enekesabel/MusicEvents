package enekes.abel.musicevents.interactor.artist

import com.orm.SugarRecord
import enekes.abel.musicevents.MusicEventsApplication
import enekes.abel.musicevents.model.Artist
import enekes.abel.musicevents.network.NetworkConfig
import enekes.abel.musicevents.network.api.ArtistEventsApi
import enekes.abel.musicevents.network.api.ArtistInformationApi
import enekes.abel.musicevents.network.api.ArtistSearchApi
import enekes.abel.musicevents.network.model.ArtistData
import enekes.abel.musicevents.network.model.EventData
import enekes.abel.musicevents.network.model.artist_search.ArtistSearchEntry
import io.reactivex.Observable
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class ArtistsInteractor {
    private companion object {
        @JvmStatic
        val method: String = "artist.search"
        @JvmStatic
        val apiKey: String = "3d9e023097347bcbbbf01b689024369c"
        @JvmStatic
        val format = "json"
        @JvmStatic
        val limit = 5
    }

    @Inject
    lateinit var artistInformationApi: ArtistInformationApi

    @Inject
    lateinit var artistEventsApi: ArtistEventsApi

    @Inject
    lateinit var artistSearchApi: ArtistSearchApi

    init {
        MusicEventsApplication.injector.inject(this)
    }

    fun searchArtist(artistName: String): Observable<List<ArtistSearchEntry>> {
        return Observable.create { subscriber ->
            val response = this.artistSearchApi.searchArtist(method, artistName, limit, apiKey, format).execute()

            if (response.isSuccessful) {
                val artistList = response.body()!!.results.artistmatches.artist
                subscriber.onNext(artistList)
                subscriber.onComplete()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }

    fun getArtist(artistName: String): Observable<Artist> {
        return Observable.create { subscriber ->

            val response = this.artistInformationApi.artist(artistName, NetworkConfig.APP_KEY).execute()

            if (response.isSuccessful) {
                val artistData = response.body()

                var artist: Artist? = SugarRecord.findById(Artist::class.java, artistData?.id)
                val isAlreadyFavourite = artist?.isFavourite ?: false
                artist = Artist(artistData!!)
                artist.isFavourite = isAlreadyFavourite

                subscriber.onNext(artist)
                subscriber.onComplete()
            } else {
                subscriber.onError(Throwable(response.message()))
            }

        }
    }

    fun markFavourite(artist: Artist){
        artist.isFavourite = true
        SugarRecord.save(artist)
    }

    fun unmarkFavourite(artist: Artist){
        artist.isFavourite = false
        SugarRecord.save(artist)
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