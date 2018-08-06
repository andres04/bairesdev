package pe.andres.bairesdev.ui.home

import android.os.Bundle

import pe.andres.bairesdev.R
import pe.andres.bairesdev.ui.common.BaseActivity
import pe.andres.bairesdev.ui.home.tabs.view.TabsFragment

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        if (savedInstanceState == null) {
            addFragment(R.id.parent_fragment_container, TabsFragment())
        }
    }
}
