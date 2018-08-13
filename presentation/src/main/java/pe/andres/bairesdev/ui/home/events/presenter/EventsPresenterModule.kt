package pe.andres.bairesdev.ui.home.events.presenter

import dagger.Binds
import dagger.Module
import dagger.Provides
import pe.andres.bairesdev.domain.executor.AppExecutor
import pe.andres.bairesdev.domain.executor.PostExecutionThread
import pe.andres.bairesdev.domain.repositories.EventsRepository
import pe.andres.bairesdev.domain.usecases.EventsUseCase
import pe.andres.bairesdev.inject.PerChildFragment

@Module
abstract class EventsPresenterModule {

    @Binds
    @PerChildFragment
    internal abstract fun eventsPresenter(eventsPresenter: EventsPresenterImpl): EventsPresenter

    @Module
    companion object {

        /*Crea una instancia de los Casos de Uso que se utilizarán y se encuentran en la capa de domain*/
        @JvmStatic
        @Provides
        @PerChildFragment
        internal fun providesNoteUseCase(
                                         appExecutor: AppExecutor,
                                         postExecutionThread: PostExecutionThread,
                                         eventsRepository: EventsRepository): EventsUseCase {
            return EventsUseCase(appExecutor, postExecutionThread, eventsRepository)
        }

    }

}
