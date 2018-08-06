package pe.andres.bairesdev.ui.home.tabs.view

import android.app.Fragment
import android.app.FragmentManager
import android.support.v13.app.FragmentPagerAdapter
import pe.andres.bairesdev.ui.home.events.view.EventsFragment

/**
 * @author andres.escobar on 21/08/2017.
 */
internal class TabPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        return when(position){
            0 -> {
                EventsFragment()
            }
            1 -> {
                EventsFragment()
            }
            2 -> {
                EventsFragment()
            }
            else ->{
                null
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }
}
