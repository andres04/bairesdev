package pe.andres.bairesdev.domain.usecases

import android.util.Log
import pe.andres.bairesdev.domain.dtos.EventDTO
import pe.andres.bairesdev.domain.dtos.EventsRequestDTO
import pe.andres.bairesdev.domain.executor.AppExecutor
import pe.andres.bairesdev.domain.executor.PostExecutionThread
import pe.andres.bairesdev.domain.observer.BaseObserver
import pe.andres.bairesdev.domain.repositories.EventsRepository
import javax.inject.Inject

class EventsUseCase
@Inject constructor(
        appExecutor: AppExecutor,
        postExecutionThread: PostExecutionThread,
        val eventsRepository: EventsRepository)
    : UseCase(appExecutor, postExecutionThread)

{

    fun getEvents(eventsRequestDTO: EventsRequestDTO, observer: BaseObserver<List<EventDTO>>) {
        val observable = eventsRepository.getEvents(eventsRequestDTO)
        execute(observable, observer)
    }

}