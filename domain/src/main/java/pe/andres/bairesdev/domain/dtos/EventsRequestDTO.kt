package pe.andres.bairesdev.domain.dtos

data class EventsRequestDTO(
    val startDate: String,
    val endDate: String,
    val includeSuggested: String)
