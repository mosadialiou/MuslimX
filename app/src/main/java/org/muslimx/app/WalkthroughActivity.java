package org.muslimx.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.muslimx.app.ui.base.BaseActivity;
import org.muslimx.app.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mohamed Sadialiou Barry on 5/4/17.
 * you can contact me at : mosadialiou@gmail.com
 */

public class WalkthroughActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.viewpager)
    protected ViewPager mViewPager;

    @BindView(R.id.viewpager_indicator_wrapper)
    protected LinearLayout mIndicatorWrapper;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_walkthrough);

        setUnBinder(ButterKnife.bind(this));
        setupViewPager();

        int count = mViewPager.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            ImageView imgV = new ImageView(this);
            setDotImg(imgV, R.drawable.bulle_off);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(Utils.dpToPx(getResources(), 5), 0, Utils.dpToPx(getResources(), 5), 0);

            mIndicatorWrapper.addView(imgV, params);
        }

        setDotImg(mIndicatorWrapper.getChildAt(0), R.drawable.bulle_on);

        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    protected void onDestroy() {
        mViewPager.removeOnPageChangeListener(this);
        super.onDestroy();
    }

    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(WalkthroughFragment.newInstance(R.drawable.walkthrough_defi_bg, R.string.defi_collectif, R.string.je_lance_un_defi_collectif, R.string.walkthrough_defi_desc));
        adapter.addFragment(WalkthroughFragment.newInstance(R.drawable.walkthrough_partager_bg, R.string.walkthrough_partager_title, R.string.walkthrough_partager_subtitle, R.string.walkthrough_partager_desc));
        adapter.addFragment(WalkthroughFragment.newInstance(R.drawable.walkthrough_se_divertir_bg, R.string.walkthrough_se_divertir_title, R.string.walkthrough_se_divertir_subtitle, R.string.walkthrough_se_divertir_desc));
        adapter.addFragment(WalkthroughFragment.newInstance(R.drawable.walkthrough_espace_pro_bg, R.string.walkthrough_espace_pro_title, R.string.walkthrough_espace_pro_subtitle, R.string.walkthrough_espace_pro_desc));
        mViewPager.setAdapter(adapter);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        int count = mIndicatorWrapper.getChildCount();
        for (int i = 0; i < count; i++) {
            setDotImg(mIndicatorWrapper.getChildAt(i), R.drawable.bulle_off);
        }

        setDotImg(mIndicatorWrapper.getChildAt(position), R.drawable.bulle_on);

        if (position == count - 1) {
            startActivity(new Intent(this, AuthenticationActivity.class));
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void setDotImg(View imgV, int resId) {
        ((ImageView) imgV).setImageDrawable(ContextCompat.getDrawable(this, resId));
    }
}
