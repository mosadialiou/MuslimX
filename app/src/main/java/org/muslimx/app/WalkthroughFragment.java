package org.muslimx.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.muslimx.app.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mohamed Sadialiou Barry on 5/4/17.
 * you can contact me at : mosadialiou@gmail.com
 */

public class WalkthroughFragment extends BaseFragment {

    private static final String BG_RES_ID = "bgResId";
    private static final String TITLE_RES_ID = "titleResId";
    private static final String SUB_TITLE_RES_ID = "subTitleResId";
    private static final String DESC_RES_ID = "descResId";

    @BindView(R.id.bg_imgV)
    protected ImageView mBackgroundImgV;

    @BindView(R.id.title_lbl)
    protected TextView mTitleLbl;

    @BindView(R.id.sub_title_lbl)
    protected TextView mSubTitleLbl;

    @BindView(R.id.desc_lbl)
    protected TextView mDescLbl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_walkthrough, container, false);
        setUnBinder(ButterKnife.bind(this, view));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle args = getArguments();
        mBackgroundImgV.setImageResource(args.getInt(BG_RES_ID));
        mTitleLbl.setText(args.getInt(TITLE_RES_ID));
        mSubTitleLbl.setText(args.getInt(SUB_TITLE_RES_ID));
        mDescLbl.setText(args.getInt(DESC_RES_ID));

    }

    public static Fragment newInstance(int bgResId, int titleResId, int subTitleResId, int descResId) {
        Fragment fragment = new WalkthroughFragment();
        Bundle args = new Bundle();
        args.putInt(BG_RES_ID, bgResId);
        args.putInt(TITLE_RES_ID, titleResId);
        args.putInt(SUB_TITLE_RES_ID, subTitleResId);
        args.putInt(DESC_RES_ID, descResId);
        fragment.setArguments(args);
        return fragment;
    }
}
