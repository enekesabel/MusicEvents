package enekes.abel.musicevents.ui.artists

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import enekes.abel.musicevents.R
import enekes.abel.musicevents.databinding.FragmentArtistBinding
import enekes.abel.musicevents.model.Artist
import javax.inject.Inject

class ArtistFragment : Fragment() {

    private lateinit var binding: FragmentArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_artist_list, container, false)

        return binding.root
    }


}
