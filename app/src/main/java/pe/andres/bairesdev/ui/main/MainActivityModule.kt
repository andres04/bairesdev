package pe.andres.bairesdev.ui.main

import android.app.Activity

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import pe.andres.bairesdev.inject.PerActivity
import pe.andres.bairesdev.inject.PerFragment
import pe.andres.bairesdev.ui.common.BaseActivityModule
import pe.andres.bairesdev.ui.home.tabs.view.TabsFragment
import pe.andres.bairesdev.ui.home.tabs.view.TabsFragmentModule
import pe.andres.bairesdev.ui.main.view.MainFragment
import pe.andres.bairesdev.ui.main.view.MainFragmentListener
import pe.andres.bairesdev.ui.main.view.MainFragmentModule

@Module(includes = arrayOf(BaseActivityModule::class))
abstract class MainActivityModule {

    @PerFragment
    @ContributesAndroidInjector(modules = arrayOf(MainFragmentModule::class))
    internal abstract fun mainFragmentInjector(): MainFragment

    @PerFragment
    @ContributesAndroidInjector(modules = arrayOf(TabsFragmentModule::class))
    internal abstract fun example3ParentFragmentInjector(): TabsFragment

    @Binds
    @PerActivity
    internal abstract fun activity(mainActivity: MainActivity): Activity

    @Binds
    @PerActivity
    internal abstract fun mainFragmentListener(mainActivity: MainActivity): MainFragmentListener

}
