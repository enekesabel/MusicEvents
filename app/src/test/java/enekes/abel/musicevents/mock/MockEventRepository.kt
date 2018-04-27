package enekes.abel.musicevents.mock

import enekes.abel.musicevents.model.Event

class MockEventRepository : MockSugarRepository<Event>() {

    fun create(): Event {
        return super.create(Event::class.java)
    }
}