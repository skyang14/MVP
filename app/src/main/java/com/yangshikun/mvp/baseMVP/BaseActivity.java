package com.yangshikun.mvp.baseMVP;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by yang.shikun on 2020/3/6 14:41
 */

public abstract class BaseActivity<T extends BaseActivityPresenter> extends SupportActivity {
    protected T mPresenter;
    private Unbinder binder;
    private CompositeDisposable compositeDisposable;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        setContentView(getLayoutId());
        binder = ButterKnife.bind(this);
        compositeDisposable = new CompositeDisposable();
        mPresenter.attachView(this);
        //关联生命周期到Presenter
        if(mPresenter != null) {
            getLifecycle().addObserver(mPresenter);
        }
    }

    /**
     * 添加订阅
     * @param disposable
     */
    public void addDisposable(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    /**
     * 取消所有订阅
     */
    public void clearDisposable() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
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
        getLifecycle().removeObserver(mPresenter);
        super.onDestroy();
        clearDisposable();
        binder.unbind();
    }

    public abstract T createPresenter();

    /**
     * 获得布局layout
     *
     * @return 布局Layout
     */
    protected abstract int getLayoutId();
}
