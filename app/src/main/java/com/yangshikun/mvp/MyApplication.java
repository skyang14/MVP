package com.yangshikun.mvp;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.SPStaticUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.Utils;

/**
 * Created by yang.shikun on 2020/3/17 11:14
 */

public class MyApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        SPStaticUtils.setDefaultSPUtils(SPUtils.getInstance("MVP"));
    }
}
