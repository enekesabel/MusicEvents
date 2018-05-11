package enekes.abel.musicevents.ui.events

import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import com.google.android.gms.analytics.HitBuilders
import com.google.android.gms.analytics.Tracker
import enekes.abel.musicevents.MusicEventsApplication
import enekes.abel.musicevents.databinding.FragmentEventListBinding
import enekes.abel.musicevents.model.Event
import enekes.abel.musicevents.ui.artists.ArtistListScreen
import enekes.abel.musicevents.ui.main.ArtistDetailsOpener
import enekes.abel.musicevents.ui.utils.AbstractBoundFragment
import enekes.abel.musicevents.ui.utils.AnalyticsApplication
import enekes.abel.musicevents.ui.utils.OnBoundItemClickListener
import javax.inject.Inject


class EventListFragment : AbstractBoundFragment<EventListScreen,
        FragmentEventListBinding>(),
        EventListScreen,
        OnBoundItemClickListener {

    @Inject
    override lateinit var presenter: EventPresenter
    private lateinit var artistDetailsOpener: ArtistDetailsOpener
    private lateinit var mTracker: Tracker

    override fun onStart() {
        super.onStart()
        artistDetailsOpener = activity as ArtistDetailsOpener
        presenter.getEvents()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val application = activity.application as AnalyticsApplication
        mTracker = application.getDefaultTracker()
    }

    override fun onResume() {
        super.onResume()
        mTracker.setScreenName("Image~ArtistList")
        mTracker.send(HitBuilders.ScreenViewBuilder().build())
    }

    override fun onItemClick(item: Any) {
        val event = item as Event
        artistDetailsOpener.showArtistById(event.artist?.artistId!!)
    }

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentEventListBinding {
        return FragmentEventListBinding.inflate(inflater, container, false)
    }

    override fun injectDependency() {
        MusicEventsApplication.injector.inject(this)
    }

    override fun showEventList(events: List<Event>) {
        binding.eventsAdapter = EventRecyclerViewAdapter(events, activity, this)
    }
}