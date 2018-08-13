package pe.andres.bairesdev.data.restservices

import dagger.Binds
import dagger.Module
import pe.andres.bairesdev.data.restservices.impl.EventsRestServiceImpl
import javax.inject.Singleton

@Module
abstract class RestServicesModule {

    @Binds
    @Singleton
    internal abstract fun eventsRestService(eventsRestServiceImpl: EventsRestServiceImpl): EventsRestService

}