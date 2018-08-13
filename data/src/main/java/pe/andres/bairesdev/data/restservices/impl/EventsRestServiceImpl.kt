package pe.andres.bairesdev.data.restservices.impl

import android.app.Application
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pe.andres.bairesdev.data.entities.EventEntity
import pe.andres.bairesdev.data.restservices.EventsRestService
import pe.andres.bairesdev.domain.dtos.EventsRequestEntity
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventsRestServiceImpl @Inject constructor(private val application: Application) : EventsRestService {

    private val service = Retrofit.Builder()
            .baseUrl("https://webservices.vividseats.com")
            .client(getClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).build().create(EventsRestService::class.java)?.let { it }

    override fun getEvents(request: EventsRequestEntity): Observable<List<EventEntity>> {
        return Observable.create { emitter ->
            try {
                service?.let {
                    it.getEvents(request)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe({
                                it?.let { it1 -> emitter.onNext(it1) }
                                        ?: emitter.onError(NullPointerException(javaClass.canonicalName))
                            },
                                    { error -> emitter.onError(error) },
                                    { emitter.onComplete() }
                            )
                }

            } catch (exception: Exception) {
                emitter.onError(exception)
            }
        }
    }

    private fun getClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

}