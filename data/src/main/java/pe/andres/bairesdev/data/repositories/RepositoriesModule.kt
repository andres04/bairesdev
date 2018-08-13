package pe.andres.bairesdev.data.repositories

import dagger.Binds
import dagger.Module
import pe.andres.bairesdev.domain.repositories.EventsRepository
import pe.andres.bairesdev.data.repositories.impl.EventsRepositoryImpl
import javax.inject.Singleton

@Module
abstract class RepositoriesModule {

    @Binds
    @Singleton
    internal abstract fun eventsRepository(eventsRepositoryImpl: EventsRepositoryImpl): EventsRepository

}