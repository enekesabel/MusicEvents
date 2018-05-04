package enekes.abel.musicevents.model

import com.orm.SugarRecord
import enekes.abel.musicevents.network.model.EventData

class Event: SugarRecord {

    private var eventId: String? = null
    private var artistId: String? = null
    private var url: String? = null
    private var datetime: String? = null
    private var description: String? = null
    private var isFavourite: Boolean = false

    constructor(eventData: EventData){
        this.eventId = eventData.id
        this.artistId = eventData.artistId
        this.url = eventData.url
        this.datetime = eventData.datetime
        this.description = eventData.description
    }
}