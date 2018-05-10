package enekes.abel.musicevents.model

import com.orm.SugarRecord
import com.orm.dsl.Unique
import enekes.abel.musicevents.network.model.ArtistData
import enekes.abel.musicevents.network.model.artist_search.ArtistSearchEntry

class Artist(artistData: ArtistData?) : SugarRecord() {

    @Unique
    var artistId: Int? = null
    var name: String? = null
    var url: String? = null
    var imageUrl: String? = null
    var imageFile: String? = null
    var facebookPageUrl: String? = null

    var favourite: Boolean = false

    init {
        if (artistData != null) {
            this.artistId = artistData.id
            this.url = artistData.url
            this.imageUrl = artistData.imageUrl
            this.name = artistData.name
            this.facebookPageUrl = artistData.facebookPageUrl
        }
    }

    constructor(artistName: String) : this() {
        name = artistName
    }

    constructor(artistData: ArtistSearchEntry) : this(artistData.name)


    constructor() : this(null)
}