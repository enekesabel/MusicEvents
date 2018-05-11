package enekes.abel.musicevents.ui.artists
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.android.gms.analytics.HitBuilders
import com.google.android.gms.analytics.Tracker
import enekes.abel.musicevents.MusicEventsApplication
import enekes.abel.musicevents.databinding.FragmentArtistListBinding
import enekes.abel.musicevents.model.Artist
import enekes.abel.musicevents.ui.main.ArtistDetailsOpener
import enekes.abel.musicevents.ui.utils.AbstractBoundFragment
import enekes.abel.musicevents.ui.utils.AnalyticsApplication
import enekes.abel.musicevents.ui.utils.OnBoundItemClickListener
import javax.inject.Inject

class ArtistListFragment : AbstractBoundFragment<ArtistListScreen, FragmentArtistListBinding>(),
        ArtistListScreen,
        OnBoundItemClickListener {

    @Inject
    override lateinit var presenter: ArtistsPresenter
    private lateinit var artistDetailsOpener: ArtistDetailsOpener
    private lateinit var mTracker: Tracker

    override fun injectDependency() {
        MusicEventsApplication.injector.inject(this)
    }

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentArtistListBinding {
        return FragmentArtistListBinding.inflate(inflater, container, false)
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

    override fun onStart() {
        super.onStart()
        artistDetailsOpener = activity as ArtistDetailsOpener
        presenter.getArtists()
    }

    override fun showArtistByName(artistName: String) {
        this.artistDetailsOpener.showArtistByName(artistName)
    }
    override fun showArtistById(artistId: Int) {
        this.artistDetailsOpener.showArtistById(artistId)
    }

    override fun onItemClick(item: Any) {
        val artist = item as Artist
        showArtistById(artist.artistId!!)
    }

    override fun showArtistList(artists: List<Artist>) {
        binding.artistsAdapter = ArtistRecyclerViewAdapter(artists, activity, this)
    }

}