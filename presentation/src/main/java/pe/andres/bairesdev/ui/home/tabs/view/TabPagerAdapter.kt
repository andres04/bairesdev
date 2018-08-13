package pe.andres.bairesdev.ui.home.tabs.view

import android.app.Fragment
import android.app.FragmentManager
import android.support.v13.app.FragmentPagerAdapter
import android.support.v13.app.FragmentStatePagerAdapter
import pe.andres.bairesdev.ui.home.events.view.EventsFragment

/**
 * @author andres.escobar on 21/08/2017.
 */
internal class TabPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    val eventsFragmentAll = EventsFragment()
    val eventsFragmentViewed = EventsFragment()
    val eventsFragmentFavourites = EventsFragment()

    override fun getItem(position: Int): Fragment? {
        return when(position){
            0 -> {
                eventsFragmentAll
            }
            1 -> {
                eventsFragmentViewed
            }
            2 -> {
                eventsFragmentFavourites
            }
            else ->{
                null
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    fun filter(text: CharSequence?, position: Int) {
        (getItem(position) as EventsFragment).filter(text)
    }
}
