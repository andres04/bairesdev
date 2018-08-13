package pe.andres.bairesdev.ui.common;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;

import pe.andres.bairesdev.inject.PerActivity;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class BaseActivityModule {

    static final String ACTIVITY_FRAGMENT_MANAGER = "BaseActivityModule.activityFragmentManager";

    @Binds
    @PerActivity

    abstract Context activityContext(Activity activity);

    @Provides
    @Named(ACTIVITY_FRAGMENT_MANAGER)
    @PerActivity
    static FragmentManager activityFragmentManager(Activity activity) {
        return activity.getFragmentManager();
    }
}
