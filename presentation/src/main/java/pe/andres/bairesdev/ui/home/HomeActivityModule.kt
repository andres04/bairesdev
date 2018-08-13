package pe.andres.bairesdev.ui.home

import android.app.Activity

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import pe.andres.bairesdev.inject.PerActivity
import pe.andres.bairesdev.inject.PerFragment
import pe.andres.bairesdev.ui.common.BaseActivityModule
import pe.andres.bairesdev.ui.home.tabs.view.TabsFragment
import pe.andres.bairesdev.ui.home.tabs.view.TabsFragmentModule

@Module(includes = arrayOf(BaseActivityModule::class))
abstract class HomeActivityModule {

    @PerFragment
    @ContributesAndroidInjector(modules = arrayOf(TabsFragmentModule::class))
    internal abstract fun tabsFragmentInjector(): TabsFragment

    @Binds
    @PerActivity
    internal abstract fun activity(homeActivity: HomeActivity): Activity
}
