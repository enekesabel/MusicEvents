package enekes.abel.musicevents.model

import com.orm.SugarRecord
import enekes.abel.musicevents.network.model.ArtistData

class Artist: SugarRecord<Artist> {

    private var artistId: Int? = null
    private var name: String? = null
    private var url: String? = null
    private var imageUrl: String? = null
    private var facebookPageUrl: String? = null
    private var isFavourite: Boolean = false

    constructor(artistData: ArtistData){
        this.artistId = artistData.id
        this.url = artistData.url
        this.imageUrl = artistData.imageUrl
        this.name = artistData.name
        this.facebookPageUrl = artistData.facebookPageUrl
    }


}