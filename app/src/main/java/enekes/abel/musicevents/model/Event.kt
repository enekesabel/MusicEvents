package enekes.abel.musicevents.model

import com.orm.SugarRecord
import com.orm.dsl.Unique
import enekes.abel.musicevents.network.model.EventData
import java.text.SimpleDateFormat
import java.util.*

class Event(eventData: EventData?) : SugarRecord() {

    @Unique
    var eventId: String? = null
    private var artistId: String? = null
    private var datetime: Date? = null
    var url: String? = null
    var description: String? = null
    var favourite: Boolean = false
    var artist: Artist? = null
    var locationName: String? = null
    var city: String? = null
    val date: String
        get() {
            return SimpleDateFormat("yyyy.MM.dd. HH:mm").format(datetime)
        }

    init {
        if (eventData != null) {
            val sourceDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            this.eventId = eventData.id
            this.artistId = eventData.artistId
            this.url = eventData.url
            this.datetime = sourceDateFormat.parse(eventData.datetime)
            this.description = eventData.description
            this.locationName = eventData.venue.name
            this.city = eventData.venue.city
        }
    }

    constructor() : this(null)

}