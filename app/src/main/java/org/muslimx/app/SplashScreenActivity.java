package org.muslimx.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import org.muslimx.app.ui.base.BaseActivity;

/**
 * Created by Mohamed Sadialiou Barry on 5/4/17.
 * you can contact me at : mosadialiou@gmail.com
 */

public class SplashScreenActivity extends BaseActivity {

    private static int SPLASH_TIMEOUT = 2000;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        mHandler.postDelayed(mRunnable, SPLASH_TIMEOUT);
    }

    @Override
    protected void onDestroy() {
        mHandler.removeCallbacks(mRunnable);
        super.onDestroy();
    }

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            if (isFinishing() || isDestroyed()) return;

            if (appLaunched() && userLoggedIn()) {
                startActivity(new Intent(SplashScreenActivity.this, HomeActivity.class));
            } else if (appLaunched()) {
                startActivity(new Intent(SplashScreenActivity.this, AuthenticationActivity.class));
            } else {
                startActivity(new Intent(SplashScreenActivity.this, WalkthroughActivity.class));
            }
        }
    };

    private boolean userLoggedIn() {
        return false;
    }

    private boolean appLaunched() {
        return false;
    }
}
