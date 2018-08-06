package pe.andres.bairesdev.ui.home.events.model

data class EventsRequest(
    val startDate: String,
    val endDate: String,
    val includeSuggested: String)
