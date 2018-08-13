package pe.andres.bairesdev.data.executor

import pe.andres.bairesdev.domain.executor.AppExecutor
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppExecutorImpl @Inject
constructor() : AppExecutor {

    private val threadPoolExecutor: ThreadPoolExecutor

    init {
        val workQueue = LinkedBlockingQueue<Runnable>()
        this.threadPoolExecutor = ThreadPoolExecutor(INITIAL_POOL_SIZE, MAX_POOL_SIZE,
                KEEP_ALIVE_TIME.toLong(), KEEP_ALIVE_TIME_UNIT, workQueue, JobThreadFactory())
    }

    override fun execute(runnable: Runnable) {
        this.threadPoolExecutor.execute(runnable)
    }

    private class JobThreadFactory : ThreadFactory {
        private var counter = 0

        override fun newThread(runnable: Runnable): Thread {
            return Thread(runnable, THREAD_NAME + counter++)
        }

        companion object {
            internal val THREAD_NAME = "android_"
        }
    }

    companion object {

        private val NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors()
        private val INITIAL_POOL_SIZE = NUMBER_OF_CORES
        private val MAX_POOL_SIZE = NUMBER_OF_CORES
        private val KEEP_ALIVE_TIME = 10
        private val KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS
    }

}
