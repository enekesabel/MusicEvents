package enekes.abel.musicevents.ui.artists
import android.view.LayoutInflater
import android.view.ViewGroup
import enekes.abel.musicevents.MusicEventsApplication
import enekes.abel.musicevents.databinding.FragmentArtistListBinding
import enekes.abel.musicevents.model.Artist
import enekes.abel.musicevents.ui.utils.AbstractBoundFragment
import enekes.abel.musicevents.ui.utils.OnBoundItemClickListener
import javax.inject.Inject

class ArtistListFragment : AbstractBoundFragment<ArtistListScreen, FragmentArtistListBinding>(),
        ArtistListScreen,
        OnBoundItemClickListener {

    @Inject
    override lateinit var presenter: ArtistsPresenter
    private lateinit var artistDetailsOpener: ArtistListScreen

    override fun injectDependency() {
        MusicEventsApplication.injector.inject(this)
    }

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentArtistListBinding {
        return FragmentArtistListBinding.inflate(inflater, container, false)
    }

    override fun onStart() {
        super.onStart()
        artistDetailsOpener = activity as ArtistListScreen
        presenter.getArtists()
    }

    override fun showArtist(artistName: String) {
        this.artistDetailsOpener.showArtist(artistName)
    }

    override fun onItemClick(item: Any) {
        val artist = item as Artist
        showArtist(artist.name!!)
    }

    override fun showArtistList(artists: List<Artist>) {
        binding.artistsAdapter = ArtistRecyclerViewAdapter(artists, activity, this)
    }

}