package pe.andres.bairesdev.util;

import android.app.Activity;

import pe.andres.bairesdev.inject.PerActivity;

import javax.inject.Inject;

@PerActivity
public final class PerActivityUtil {

    private final Activity activity;

    @Inject
    PerActivityUtil(Activity activity) {
        this.activity = activity;
    }

    /**
     * @return the result of the work done here as a string. For this example, this returns its
     * {@link #hashCode()} and the activity's {@link #hashCode()}.
     */
    public String doSomething() {
        return "PerActivityUtil: " + hashCode() + ", Activity: " + activity.hashCode();
    }
}
