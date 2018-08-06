package pe.andres.bairesdev.ui.home.events.view

import pe.andres.bairesdev.ui.common.view.BaseView
import pe.andres.bairesdev.ui.home.events.model.EventModel

interface EventsView : BaseView {

    fun showEvents(events: List<EventModel?>?)
}
