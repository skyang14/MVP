package com.yangshikun.mvp.test;

import android.view.View;

import com.yangshikun.mvp.R;
import com.yangshikun.mvp.baseMVP.BaseFragment;

/**
 * Created by yang.shikun on 2020/3/16 14:29
 */

public class AFragment extends BaseFragment<AFragPresenter> {

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {

    }


    @Override
    protected int getLayoutId() {
        return R.layout.frament_a;
    }

    @Override
    public AFragPresenter createPresenter() {
        return new AFragPresenter();
    }


}
