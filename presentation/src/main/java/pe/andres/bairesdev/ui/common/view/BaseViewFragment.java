package pe.andres.bairesdev.ui.common.view;

import android.os.Bundle;
import android.support.annotation.CallSuper;

import pe.andres.bairesdev.App;
import pe.andres.bairesdev.ui.common.presenter.Presenter;

import javax.inject.Inject;

public abstract class BaseViewFragment<T extends Presenter> extends BaseFragment
        implements BaseView {


//    static Prefs prefs = App.getPrefs()

    @Inject
    protected T presenter;

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        presenter.onStart(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @CallSuper
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        presenter.onEnd();
        super.onDestroyView();
    }
}
