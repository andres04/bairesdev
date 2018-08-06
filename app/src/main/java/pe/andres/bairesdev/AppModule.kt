package pe.andres.bairesdev

import android.app.Application

import javax.inject.Singleton

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector
import pe.andres.bairesdev.inject.PerActivity
import pe.andres.bairesdev.ui.home.HomeActivity
import pe.andres.bairesdev.ui.home.HomeActivityModule
import pe.andres.bairesdev.ui.main.MainActivity
import pe.andres.bairesdev.ui.main.MainActivityModule

@Module(includes = arrayOf(AndroidInjectionModule::class))
internal abstract class AppModule {

    @Binds
    @Singleton
    internal abstract fun application(app: App): Application

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    internal abstract fun mainActivityInjector(): MainActivity

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(HomeActivityModule::class))
    internal abstract fun example3ActivityInjector(): HomeActivity
}
