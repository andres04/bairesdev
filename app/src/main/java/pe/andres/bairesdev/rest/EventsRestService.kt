package pe.andres.bairesdev.rest

import io.reactivex.Observable
import pe.andres.bairesdev.ui.home.events.model.EventModel
import pe.andres.bairesdev.ui.home.events.model.EventsRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface EventsRestService {

    @POST(value = "/rest/mobile/v1/home/cards")
    fun getEvents(@Body request: EventsRequest) : Observable<List<EventModel?>?>

}