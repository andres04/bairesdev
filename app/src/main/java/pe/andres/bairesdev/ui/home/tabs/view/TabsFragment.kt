package pe.andres.bairesdev.ui.home.tabs.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_tabs.*
import pe.andres.bairesdev.R
import pe.andres.bairesdev.ui.common.view.BaseViewFragment
import pe.andres.bairesdev.ui.home.tabs.presenter.TabsPresenter


class TabsFragment : BaseViewFragment<TabsPresenter>(), TabsView {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tabs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var mainPagerAdapter = TabPagerAdapter(childFragmentManager)

        vpg_main.adapter = mainPagerAdapter
        tlt_tabs.setupWithViewPager(vpg_main)

        tlt_tabs.getTabAt(0)?.text = getString(R.string.suggested)
        tlt_tabs.getTabAt(1)?.text = getString(R.string.viewed)
        tlt_tabs.getTabAt(2)?.text = getString(R.string.favorites)
    }

    override fun showSomething(something: String) {

    }

}
