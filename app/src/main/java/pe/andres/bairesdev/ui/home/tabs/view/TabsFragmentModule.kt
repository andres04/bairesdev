package pe.andres.bairesdev.ui.home.tabs.view

import android.app.Fragment

import pe.andres.bairesdev.inject.PerChildFragment
import pe.andres.bairesdev.inject.PerFragment
import pe.andres.bairesdev.ui.common.view.BaseFragmentModule
import pe.andres.bairesdev.ui.home.events.view.EventsFragment
import pe.andres.bairesdev.ui.home.events.view.EventsFragmentModule
import pe.andres.bairesdev.ui.home.tabs.presenter.TabsPresenterModule

import javax.inject.Named

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = arrayOf(BaseFragmentModule::class, TabsPresenterModule::class))
abstract class TabsFragmentModule {

    @PerChildFragment
    @ContributesAndroidInjector(modules = arrayOf(EventsFragmentModule::class))
    internal abstract fun example3ChildFragmentInjector(): EventsFragment

    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    internal abstract fun fragment(tabsFragment: TabsFragment): Fragment

    @Binds
    @PerFragment
    internal abstract fun example3ParentView(tabsFragment: TabsFragment): TabsView
}
