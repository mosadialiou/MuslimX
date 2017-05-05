package org.muslimx.app.ui.base;

/**
 * Created by Mohamed Sadialiou Barry on 3/28/17.
 * you can contact me at : mosadialiou@gmail.com
 */

public interface MvpPresenter<V extends MvpView> {

    void onCreate();

    void onStart();

    void onStop();

    void onPause();

    void onAttach(V mvpView);

    void onDetach();
}
