package pe.andres.bairesdev.ui.home.events.presenter

import pe.andres.bairesdev.domain.dtos.EventsRequestDTO
import pe.andres.bairesdev.ui.common.presenter.Presenter


interface EventsPresenter : Presenter {

    fun getEvents(eventsRequest: EventsRequestDTO)
}
