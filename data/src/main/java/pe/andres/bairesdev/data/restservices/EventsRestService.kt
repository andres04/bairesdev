package pe.andres.bairesdev.data.restservices

import io.reactivex.Observable
import pe.andres.bairesdev.data.entities.EventEntity
import pe.andres.bairesdev.domain.dtos.EventsRequestEntity
import retrofit2.http.Body
import retrofit2.http.POST

interface EventsRestService {

    @POST(value = "/rest/mobile/v1/home/cards")
    fun getEvents(@Body request: EventsRequestEntity): Observable<List<EventEntity>>

}

