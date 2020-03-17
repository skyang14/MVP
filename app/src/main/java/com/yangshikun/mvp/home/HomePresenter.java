package com.yangshikun.mvp.home;

import android.util.Log;

import com.blankj.utilcode.util.ToastUtils;
import com.yangshikun.mvp.test.AFragment;
import com.yangshikun.mvp.baseMVP.BaseFragPresenter;

/**
 * Created by yang.shikun on 2020/3/17 11:31
 */

public class HomePresenter extends BaseFragPresenter<HomeFragment,HomeModel> {
    private static final String TAG = "HomePresenter";
    @Override
    protected HomeModel createModel() {
        return new HomeModel();
    }

    public void showToast(){
        getView().showTextResult(mModel.getStringFromModel());
    }

    public void go2Fragment(){
        ToastUtils.showShort("跳转AFragment");
        getView().start(new AFragment());
    }

    @Override
    public void onCreate() {
        Log.e(TAG, "onCreate: HomeFragment" );
    }

    @Override
    public void onStart() {
        Log.e(TAG, "onStart: HomeFragment" );
    }

    @Override
    public void onResume() {
        Log.e(TAG, "onResume: HomeFragment" );
    }

    @Override
    public void onPause() {
        Log.e(TAG, "onPause: HomeFragment" );
    }

    @Override
    public void onStop() {
        Log.e(TAG, "onStop: HomeFragment" );
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy: HomeFragment" );
    }
}
