package com.yangshikun.mvp;

import android.util.Log;

import com.yangshikun.mvp.baseMVP.BaseActivityPresenter;

/**逻辑处理层，可以调用View层和Model层
 * Created by yang.shikun on 2020/3/6 14:39
 */

public class MainPresenter extends BaseActivityPresenter<MainActivity,MainModel> {
    private static final String TAG = "MainPresenter";
    @Override
    protected MainModel createModel() {
        return new MainModel();
    }

    @Override
    public void onCreate() {
        Log.e(TAG, "onCreate: MainActivity");
    }

    @Override
    public void onStart() {
        Log.e(TAG, "onStart: MainActivity");
    }

    @Override
    public void onResume() {
        Log.e(TAG, "onResume: MainActivity");
    }

    @Override
    public void onPause() {
        Log.e(TAG, "onPause: MainActivity");
    }

    @Override
    public void onStop() {
        Log.e(TAG, "onStop: MainActivity");
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy: MainActivity");
    }
}
