package pe.andres.bairesdev.thread

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import pe.andres.bairesdev.domain.executor.PostExecutionThread
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UIThread @Inject
constructor() : PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}
