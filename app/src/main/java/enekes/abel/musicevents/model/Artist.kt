package enekes.abel.musicevents.model

import com.orm.SugarRecord
import com.orm.dsl.Unique
import enekes.abel.musicevents.network.model.ArtistData

class Artist(artistData: ArtistData) : SugarRecord() {

    @Unique
    private var artistId: Int? = null
    var name: String? = null
    var url: String? = null
    var imageUrl: String? = null
    var facebookPageUrl: String? = null

    var isFavourite: Boolean = false

    init {
        this.artistId = artistData.id
        this.url = artistData.url
        this.imageUrl = artistData.imageUrl
        this.name = artistData.name
        this.facebookPageUrl = artistData.facebookPageUrl
    }

}