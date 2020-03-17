package com.yangshikun.mvp.test;

import android.util.Log;

import com.yangshikun.mvp.baseMVP.BaseFragPresenter;

/**
 * Created by yang.shikun on 2020/3/16 14:30
 */

public class AFragPresenter extends BaseFragPresenter<AFragment,AFragModel> {
    private static final String TAG = "AFragPresenter";
    @Override
    protected AFragModel createModel() {
        return new AFragModel();
    }

    @Override
    public void onCreate() {
        Log.e(TAG, "onCreate: AFragment");
    }

    @Override
    public void onStart() {
        Log.e(TAG, "onStart: AFragment");
    }

    @Override
    public void onResume() {
        Log.e(TAG, "onResume: AFragment");
    }

    @Override
    public void onPause() {
        Log.e(TAG, "onPause: AFragment");
    }

    @Override
    public void onStop() {
        Log.e(TAG, "onStop: AFragment");
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy: AFragment");
    }
}
