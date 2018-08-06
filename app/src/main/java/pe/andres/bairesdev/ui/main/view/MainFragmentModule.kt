package pe.andres.bairesdev.ui.main.view

import android.app.Fragment

import pe.andres.bairesdev.inject.PerFragment
import pe.andres.bairesdev.ui.common.view.BaseFragmentModule

import javax.inject.Named

import dagger.Binds
import dagger.Module

@Module(includes = arrayOf(BaseFragmentModule::class))
abstract class MainFragmentModule {

    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    internal abstract fun fragment(mainFragment: MainFragment): Fragment
}
