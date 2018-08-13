package pe.andres.bairesdev.ui.home.events.presenter

import android.util.Log
import pe.andres.bairesdev.domain.dtos.EventDTO
import pe.andres.bairesdev.domain.dtos.EventsRequestDTO
import pe.andres.bairesdev.domain.observer.BaseObserver
import pe.andres.bairesdev.domain.usecases.EventsUseCase
import pe.andres.bairesdev.inject.PerChildFragment
import pe.andres.bairesdev.ui.common.presenter.BasePresenter
import pe.andres.bairesdev.ui.home.events.view.EventsView
import javax.inject.Inject


@PerChildFragment
internal class EventsPresenterImpl @Inject
constructor(view: EventsView,
            val eventsUseCase: EventsUseCase)
    : BasePresenter<EventsView>(view), EventsPresenter {

    override fun getEvents(eventsRequest: EventsRequestDTO) {
        eventsUseCase.getEvents(eventsRequest, object : BaseObserver<List<EventDTO>>(){
            override fun onNext(t: List<EventDTO>) {
                view.showEvents(t)
            }

            override fun onError(e: Throwable) {
                Log.e("EventsPresenterImpl", "getEvents", e)
            }
        })

    }



}
