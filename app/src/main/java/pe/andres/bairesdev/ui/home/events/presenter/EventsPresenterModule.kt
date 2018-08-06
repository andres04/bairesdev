package pe.andres.bairesdev.ui.home.events.presenter

import pe.andres.bairesdev.inject.PerChildFragment

import dagger.Binds
import dagger.Module
import pe.andres.bairesdev.rest.EventsRestService
import pe.andres.bairesdev.rest.EventsRestServiceImpl

@Module
abstract class EventsPresenterModule {

    @Binds
    @PerChildFragment
    internal abstract fun eventsPresenter(eventsPresenter: EventsPresenterImpl): EventsPresenter

    @Binds
    @PerChildFragment
    internal abstract fun eventsRestService(eventsRestService: EventsRestServiceImpl): EventsRestService

}
