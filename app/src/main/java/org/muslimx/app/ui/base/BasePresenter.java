package org.muslimx.app.ui.base;

/**
 * Created by Mohamed Sadialiou Barry on 3/30/17.
 * you can contact me at : mosadialiou@gmail.com
 */

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {
    private V mView;

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onAttach(V mvpView) {
        this.mView = mvpView;
    }


    @Override
    public void onDetach() {
        this.mView = null;
    }

    public V getView() {
        return this.mView;
    }

    public boolean isViewAttached() {
        return mView != null;
    }
}
