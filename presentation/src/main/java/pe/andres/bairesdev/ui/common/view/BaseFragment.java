package pe.andres.bairesdev.ui.common.view;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.support.annotation.IdRes;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;

public abstract class BaseFragment extends DialogFragment implements HasFragmentInjector {
    
    @Inject
    protected Context activityContext;
    
    // Note that this should not be used within a child fragment.
    @Inject
    @Named(BaseFragmentModule.CHILD_FRAGMENT_MANAGER)
    protected FragmentManager childFragmentManager;

    @Inject
    DispatchingAndroidInjector<Fragment> childFragmentInjector;


    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            AndroidInjection.inject(this);
        }
        super.onAttach(activity);
    }

    @Override
    public void onAttach(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            AndroidInjection.inject(this);
        }
        super.onAttach(context);
    }

    @Override
    public final AndroidInjector<Fragment> fragmentInjector() {
        return childFragmentInjector;
    }

    protected final void replaceChildFragment(@IdRes int containerViewId, Fragment fragment) {
        childFragmentManager.beginTransaction()
                .replace(containerViewId, fragment)
                .commit();
    }

}
