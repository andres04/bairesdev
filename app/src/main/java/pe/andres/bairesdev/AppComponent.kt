package pe.andres.bairesdev

import javax.inject.Singleton

import dagger.Component
import dagger.android.AndroidInjector


@Singleton
@Component(modules = arrayOf(AppModule::class))
internal interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}
