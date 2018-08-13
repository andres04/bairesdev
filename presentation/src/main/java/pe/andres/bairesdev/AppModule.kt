package pe.andres.bairesdev

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector
import pe.andres.bairesdev.data.restservices.RestServicesModule
import pe.andres.bairesdev.domain.executor.AppExecutor
import pe.andres.bairesdev.domain.executor.PostExecutionThread
import pe.andres.bairesdev.data.executor.AppExecutorImpl
import pe.andres.bairesdev.inject.PerActivity
import pe.andres.bairesdev.data.repositories.RepositoriesModule
import pe.andres.bairesdev.thread.UIThread
import pe.andres.bairesdev.ui.home.HomeActivity
import pe.andres.bairesdev.ui.home.HomeActivityModule
import pe.andres.bairesdev.ui.main.MainActivity
import pe.andres.bairesdev.ui.main.MainActivityModule
import javax.inject.Singleton

@Module(includes = arrayOf(AndroidInjectionModule::class, RepositoriesModule::class, RestServicesModule::class))
internal abstract class AppModule {

    /*Crea una instancia de la aplicación para que esté disponible en tod0 el proyecto*/

    @Binds
    @Singleton
    internal abstract fun application(app: App): Application

    /*Inyecta las instancias existentes de las Activities del proyecto para que esté disponible
    en los demás módulos*/

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    internal abstract fun mainActivityInjector(): MainActivity

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(HomeActivityModule::class))
    internal abstract fun homeActivityInjector(): HomeActivity

    /*Crea una instancia del AppExecutor, para que estén disponibles en los Casos de Uso*/

    @Binds
    @Singleton
    internal abstract fun appExecutor(appExecutorImpl: AppExecutorImpl): AppExecutor

    /*Crea una instancia del PostExecutorThread , para que estén disponibles en los Casos de Uso*/

    @Binds
    @Singleton
    internal abstract fun postExecutorThread(uiThread: UIThread): PostExecutionThread

}
