package org.muslimx.app.ui.base;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

import butterknife.Unbinder;

/**
 * Created by Mohamed Sadialiou Barry on 5/4/17.
 * you can contact me at : mosadialiou@gmail.com
 */

public class BaseFragment extends Fragment implements MvpView {

    private BaseActivity mActivity;
    private Unbinder mUnBinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached();
        }
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Override
    public void showLoading() {
        if (mActivity != null) mActivity.showLoading();
    }

    @Override
    public void hideLoading() {
        if (mActivity != null) mActivity.hideLoading();
    }

    @Override
    public void onError(@StringRes int resId) {
        if (mActivity != null) mActivity.onError(resId);
    }

    @Override
    public void onError(String message) {
        if (mActivity != null) mActivity.onError(message);
    }

    @Override
    public boolean isNetworkConnected() {
        return mActivity == null ? false : mActivity.isNetworkConnected();
    }

    @Override
    public void hideKeyboard() {
        if (mActivity != null) mActivity.hideKeyboard();
    }

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    public void onDestroyView() {
        if(mUnBinder != null) mUnBinder.unbind();
        super.onDestroyView();
    }

    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }
}
