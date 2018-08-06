package pe.andres.bairesdev.util;

import android.app.Fragment;

import pe.andres.bairesdev.inject.PerChildFragment;
import pe.andres.bairesdev.ui.common.view.BaseChildFragmentModule;

import javax.inject.Inject;
import javax.inject.Named;

@PerChildFragment
public final class PerChildFragmentUtil {

    private final Fragment childFragment;

    @Inject
    PerChildFragmentUtil(@Named(BaseChildFragmentModule.CHILD_FRAGMENT) Fragment childFragment) {
        this.childFragment = childFragment;
    }

    public String doSomething() {
        return "PerChildFragmentUtil: " + hashCode()
                + ", child Fragment: " + childFragment.hashCode();
    }
}
