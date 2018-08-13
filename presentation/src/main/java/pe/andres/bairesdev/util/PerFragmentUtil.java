package pe.andres.bairesdev.util;

import android.app.Fragment;

import pe.andres.bairesdev.inject.PerFragment;
import pe.andres.bairesdev.ui.common.view.BaseFragmentModule;

import javax.inject.Inject;
import javax.inject.Named;

@PerFragment
public final class PerFragmentUtil {

    private final Fragment fragment;

    @Inject
    PerFragmentUtil(@Named(BaseFragmentModule.FRAGMENT) Fragment fragment) {
        this.fragment = fragment;
    }
    
    public String doSomething() {
        return "PerFragmentUtil: " + hashCode() + ", Fragment: " + fragment.hashCode();
    }
}
