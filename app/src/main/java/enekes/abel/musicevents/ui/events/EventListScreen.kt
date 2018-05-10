package enekes.abel.musicevents.ui.events

import enekes.abel.musicevents.model.Event

interface EventListScreen {
    fun showEventList(events: List<Event>)
}