package pe.andres.bairesdev.rest

import android.app.Application
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pe.andres.bairesdev.ui.home.events.model.EventModel
import pe.andres.bairesdev.ui.home.events.model.EventsRequest
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventsRestServiceImpl @Inject constructor(private val application: Application) : EventsRestService{

    val service = Retrofit.Builder()
            .baseUrl("https://webservices.vividseats.com")
            .client(getClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).build().create(EventsRestService::class.java)

    override fun getEvents(request: EventsRequest): Observable<List<EventModel?>?> {
        return Observable.create { emitter ->
            try {
                service.getEvents(request)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            it?.let { it1 -> emitter.onNext(it1) }
                                    ?: emitter.onError(NullPointerException(javaClass.canonicalName))
                            },
                            { error -> emitter.onError(error) },
                            { emitter.onComplete() }
                        )
            } catch (exception: Exception) {
                emitter.onError(exception)
            }
        }
    }

    fun getClient(): OkHttpClient? {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

}