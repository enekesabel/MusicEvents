package enekes.abel.musicevents.ui.utils

import android.app.Fragment
import android.app.FragmentManager
import android.support.v13.app.FragmentStatePagerAdapter
import enekes.abel.musicevents.ui.artists.ArtistListFragment
import enekes.abel.musicevents.ui.events.EventListFragment

class Pager//Constructor to the class
(fm: FragmentManager, //integer to count number of tabs
 private var tabCount: Int)//Initializing tab count
    : FragmentStatePagerAdapter(fm) {

    //Overriding method getItem
    override fun getItem(position: Int): Fragment? {
        //Returning the current tabs
        return when (position) {
            0 -> {
                ArtistListFragment()
            }
            1 -> {
                EventListFragment()
            }
            else -> null
        }
    }

    //Overriden method getCount to get the number of tabs
    override fun getCount(): Int {
        return tabCount
    }
}