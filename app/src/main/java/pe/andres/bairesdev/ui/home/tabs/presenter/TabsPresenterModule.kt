package pe.andres.bairesdev.ui.home.tabs.presenter

import pe.andres.bairesdev.inject.PerFragment

import dagger.Binds
import dagger.Module

@Module
abstract class TabsPresenterModule {

    @Binds
    @PerFragment
    internal abstract fun example3ParentPresenter(example3ParentPresenterImpl: TabsPresenterImpl): TabsPresenter
}
