package enekes.abel.musicevents.network

import enekes.abel.musicevents.network.api.ArtistSearchApi
import enekes.abel.musicevents.network.model.artist_search.ArtistSearchResponse
import retrofit2.Call
import retrofit2.Retrofit

class ArtistSearchApiImpl : ArtistSearchApi {

    private val artistSearchApi: ArtistSearchApi

    init {
        val json = JSON()
        val retrofit = Retrofit.Builder()
                .baseUrl("http://ws.audioscrobbler.com/")
                .addConverterFactory(GsonCustomConverterFactory.create(json.gson))
                .build()

        artistSearchApi = retrofit.create(ArtistSearchApi::class.java)
    }


    override fun searchArtist(method: String,
                              artist: String,
                              limit: Int,
                              api_key: String,
                              format: String)
            : Call<ArtistSearchResponse> {
        return artistSearchApi.searchArtist(method, artist, limit, api_key, format)
    }
}