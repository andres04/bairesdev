package pe.andres.bairesdev.data.repositories.impl

import io.reactivex.Observable
import pe.andres.bairesdev.data.entities.EventEntity
import pe.andres.bairesdev.data.restservices.EventsRestService
import pe.andres.bairesdev.domain.dtos.EventDTO
import pe.andres.bairesdev.domain.dtos.EventsRequestDTO
import pe.andres.bairesdev.domain.dtos.EventsRequestEntity
import pe.andres.bairesdev.domain.repositories.EventsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventsRepositoryImpl
    @Inject constructor(
            val eventsRestService: EventsRestService
    ): EventsRepository{

    override fun getEvents(eventsRequestDTO: EventsRequestDTO): Observable<List<EventDTO>> {
        return eventsRestService.getEvents(EventsRequestEntity.toEntity(eventsRequestDTO))
                .map { EventEntity.toDTOList(it) }
    }
}