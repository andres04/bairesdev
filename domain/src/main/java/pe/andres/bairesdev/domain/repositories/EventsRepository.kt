package pe.andres.bairesdev.domain.repositories

import io.reactivex.Observable
import pe.andres.bairesdev.domain.dtos.EventDTO
import pe.andres.bairesdev.domain.dtos.EventsRequestDTO

interface EventsRepository{

    fun getEvents(eventsRequestDTO: EventsRequestDTO): Observable<List<EventDTO>>

}