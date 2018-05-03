package enekes.abel.musicevents.network.api

import enekes.abel.musicevents.network.model.artist_search.ArtistSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
interface  ArtistSearchApi {
    @GET("/2.0")
    fun searchArtist(@Query("method") method: String,
               @Query("artist") artist: String,
               @Query("limit") limit: Int,
               @Query("api_key") api_key: String,
               @Query("format") format: String)
            : Call<ArtistSearchResponse>
}