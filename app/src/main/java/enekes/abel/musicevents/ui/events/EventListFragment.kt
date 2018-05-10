package enekes.abel.musicevents.ui.events

import android.view.ViewGroup
import android.view.LayoutInflater
import enekes.abel.musicevents.MusicEventsApplication
import enekes.abel.musicevents.databinding.FragmentEventListBinding
import enekes.abel.musicevents.model.Event
import enekes.abel.musicevents.ui.utils.AbstractBoundFragment
import javax.inject.Inject


class EventListFragment : AbstractBoundFragment<EventListScreen, FragmentEventListBinding>(), EventListScreen {

    @Inject
    override lateinit var presenter: EventPresenter

    override fun onStart() {
        super.onStart()
        presenter.getEvents()
    }

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentEventListBinding {
        return FragmentEventListBinding.inflate(inflater, container, false)
    }

    override fun injectDependency() {
        MusicEventsApplication.injector.inject(this)
    }

    override fun showEventList(events: List<Event>) {
        binding.eventsAdapter = EventRecyclerViewAdapter(events, activity)
    }
}