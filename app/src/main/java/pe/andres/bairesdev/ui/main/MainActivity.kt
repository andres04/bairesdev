package pe.andres.bairesdev.ui.main

import android.os.Bundle
import pe.andres.bairesdev.R
import pe.andres.bairesdev.ui.common.BaseActivity
import pe.andres.bairesdev.ui.main.view.MainFragment
import pe.andres.bairesdev.ui.main.view.MainFragmentListener

class MainActivity : BaseActivity(), MainFragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container, MainFragment())
        }

    }

    override fun openHome() {

    }

}
