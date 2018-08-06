package pe.andres.bairesdev.ui.home.events.presenter

import pe.andres.bairesdev.ui.common.presenter.Presenter
import pe.andres.bairesdev.ui.home.events.model.EventsRequest


interface EventsPresenter : Presenter {

    fun getEvents(eventsRequest: EventsRequest)
}
