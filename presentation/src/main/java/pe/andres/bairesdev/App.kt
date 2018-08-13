package pe.andres.bairesdev

import android.app.Activity
import android.app.Application

import javax.inject.Inject

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector

class App : Application(), HasActivityInjector {

//    companion object {
//        var prefs: Prefs? = null
//    }

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
//        prefs = Prefs(applicationContext)
        DaggerAppComponent.builder().create(this).inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity>? {
        return activityInjector
    }

}
