package pe.andres.bairesdev.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import pe.andres.bairesdev.R
import pe.andres.bairesdev.ui.common.view.BaseFragment
import pe.andres.bairesdev.ui.home.tabs.view.TabsFragment
import javax.inject.Inject

class MainFragment : BaseFragment() {

    @Inject
    lateinit var listener: MainFragmentListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bnv_menu.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home ->{
                    replaceChildFragment(R.id.flt_main, TabsFragment())
                }
                else -> {
                    flt_main.removeAllViews()
                }
            }
            true
        }
        bnv_menu.selectedItemId = R.id.menu_home
    }

}
