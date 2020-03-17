package com.yangshikun.mvp.baseMVP;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by yang.shikun on 2020/3/16 14:04
 */

public abstract class BaseFragment<T extends BaseFragPresenter> extends SupportFragment {
    protected T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        //关联生命周期到Presenter
        if(mPresenter != null) {
            getLifecycle().addObserver(mPresenter);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPresenter.attachView(this);
        View view = inflater.inflate(getLayoutId(), container, false);
        initData();
        initView(view);
        return view;
    }

    protected abstract void initData();

    protected abstract void initView(View view);

    protected abstract int getLayoutId();

    @Override
    public void onSaveInstanceState(Bundle outState) {
        //注： 子类覆写onSaveInstanceState方法后，调用getView()返回空。
        // 可以先写自己的逻辑在调用super.onSaveInstanceState(outState)
        mPresenter.detachView();
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        mPresenter.attachView(this);
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        mPresenter.detachView();
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        getLifecycle().removeObserver(mPresenter);
        super.onDestroy();
    }

    public abstract T createPresenter();
}
