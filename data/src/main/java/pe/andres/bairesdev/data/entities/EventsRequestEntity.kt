package pe.andres.bairesdev.domain.dtos

data class EventsRequestEntity(
    val startDate: String,
    val endDate: String,
    val includeSuggested: String){

    companion object {

        fun toEntity(dto: EventsRequestDTO): EventsRequestEntity{
            return EventsRequestEntity(dto.startDate, dto.endDate, dto.includeSuggested)
        }

    }

}

