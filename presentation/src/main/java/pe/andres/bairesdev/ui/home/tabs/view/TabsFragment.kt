package pe.andres.bairesdev.ui.home.tabs.view

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_tabs.*
import pe.andres.bairesdev.R
import pe.andres.bairesdev.ui.common.view.BaseViewFragment
import pe.andres.bairesdev.ui.home.tabs.presenter.TabsPresenter


class TabsFragment : BaseViewFragment<TabsPresenter>(), TabsView {

    private var position = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tabs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainPagerAdapter = TabPagerAdapter(childFragmentManager)

        vpg_main.adapter = mainPagerAdapter
        tlt_tabs.setupWithViewPager(vpg_main)

        vpg_main.offscreenPageLimit = 3

        tlt_tabs.getTabAt(0)?.text = getString(R.string.suggested)
        tlt_tabs.getTabAt(1)?.text = getString(R.string.viewed)
        tlt_tabs.getTabAt(2)?.text = getString(R.string.favorites)

        vpg_main.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
                //empty
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                //empty
            }

            override fun onPageSelected(position: Int) {
                this@TabsFragment.position = position
                edt_filter.setText("")
            }
        })

        edt_filter.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                //empty
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //empty
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                mainPagerAdapter.filter(s, position)
            }
        })

    }

    override fun showSomething(something: String) {

    }

}
