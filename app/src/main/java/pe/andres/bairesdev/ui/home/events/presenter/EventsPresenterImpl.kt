package pe.andres.bairesdev.ui.home.events.presenter

import android.util.Log

import com.google.gson.Gson

import javax.inject.Inject

import io.reactivex.disposables.Disposable
import pe.andres.bairesdev.inject.PerChildFragment
import pe.andres.bairesdev.rest.EventsRestService
import pe.andres.bairesdev.ui.common.presenter.BasePresenter
import pe.andres.bairesdev.ui.home.events.model.EventsRequest
import pe.andres.bairesdev.ui.home.events.view.EventsView


@PerChildFragment
internal class EventsPresenterImpl @Inject
constructor(view: EventsView, private val eventsRestService: EventsRestService) : BasePresenter<EventsView>(view), EventsPresenter {

    override fun getEvents(eventsRequest: EventsRequest) {
        val eventsDisposable = eventsRestService.getEvents(eventsRequest).subscribe(
                { eventModels -> view.showEvents(eventModels) }
        ) { throwable -> Log.e("EventsPresenterImpl", "Error!", throwable) }

    }
}
