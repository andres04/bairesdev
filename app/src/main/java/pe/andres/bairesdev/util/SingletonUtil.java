package pe.andres.bairesdev.util;

import android.app.Application;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class SingletonUtil {

    private final Application application;

    @Inject
    SingletonUtil(Application application) {
        this.application = application;
    }
    
    public String doSomething() {
        return "SingletonUtil: " + hashCode() + ", Application: " + application.hashCode();
    }
}
