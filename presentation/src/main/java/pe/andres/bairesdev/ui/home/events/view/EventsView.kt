package pe.andres.bairesdev.ui.home.events.view

import pe.andres.bairesdev.domain.dtos.EventDTO
import pe.andres.bairesdev.ui.common.view.BaseView

interface EventsView : BaseView {

    fun showEvents(events: List<EventDTO?>?)
}
