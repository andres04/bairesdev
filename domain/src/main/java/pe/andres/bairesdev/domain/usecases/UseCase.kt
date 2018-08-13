package pe.andres.bairesdev.domain.usecases

import dagger.internal.Preconditions
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import pe.andres.bairesdev.domain.executor.AppExecutor
import pe.andres.bairesdev.domain.executor.PostExecutionThread

abstract class UseCase
internal constructor(private val appExecutor: AppExecutor
                    , private val postExecutionThread: PostExecutionThread) {
    private val disposables: CompositeDisposable = CompositeDisposable()

    internal fun <T> execute(observable: Observable<T>, observer: DisposableObserver<T>) {
        Preconditions.checkNotNull(observer)

        val disposable = observable
                .subscribeOn(Schedulers.from(appExecutor))
                .observeOn(postExecutionThread.scheduler)
                .subscribeWith(observer)

        addDisposable(disposable)
    }

    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    private fun addDisposable(disposable: Disposable) {
        Preconditions.checkNotNull(disposable)
        Preconditions.checkNotNull(disposables)
        disposables.add(disposable)
    }

}
