package org.muslimx.app.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by Mohamed Sadialiou Barry on 3/28/17.
 * you can contact me at : mosadialiou@gmail.com
 */

public interface MvpView {

    void showLoading();

    void hideLoading();

    void onError(@StringRes int resId);

    void onError(String message);

    boolean isNetworkConnected();

    void hideKeyboard();
}
