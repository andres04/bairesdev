package pe.andres.bairesdev.ui.home.tabs.presenter

import pe.andres.bairesdev.inject.PerFragment
import pe.andres.bairesdev.ui.common.presenter.BasePresenter
import pe.andres.bairesdev.ui.home.tabs.view.TabsView
import pe.andres.bairesdev.util.PerActivityUtil
import pe.andres.bairesdev.util.PerFragmentUtil
import pe.andres.bairesdev.util.SingletonUtil

import javax.inject.Inject


@PerFragment
internal class TabsPresenterImpl @Inject
constructor(view: TabsView, private val singletonUtil: SingletonUtil,
            private val perActivityUtil: PerActivityUtil, private val perFragmentUtil: PerFragmentUtil) : BasePresenter<TabsView>(view), TabsPresenter {

    override fun onDoSomething() {
        // Do something here. Maybe make an asynchronous call to fetch data...
        var something = singletonUtil.doSomething()
        something += "\n" + perActivityUtil.doSomething()
        something += "\n" + perFragmentUtil.doSomething()
        view.showSomething(something)
    }
}
