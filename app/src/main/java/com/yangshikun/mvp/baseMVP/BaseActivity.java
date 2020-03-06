package com.yangshikun.mvp.baseMVP;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by yang.shikun on 2020/3/6 14:41
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView(this);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        //注： 子类覆写onSaveInstanceState方法后，调用getView()返回空。
        // 可以先写自己的逻辑在调用super.onSaveInstanceState(outState)
        mPresenter.detachView();
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        mPresenter.attachView(this);
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

    public abstract T createPresenter();
}
