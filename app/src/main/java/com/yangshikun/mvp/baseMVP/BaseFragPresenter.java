package com.yangshikun.mvp.baseMVP;

/**
 * Created by yang.shikun on 2020/3/16 14:17
 */

public abstract class BaseFragPresenter<T extends BaseFragment,M extends BaseModel> implements IPresenter{
    protected T mFragment;
    protected M mModel;

    public void attachView(T fragment){
        mFragment = fragment;
        if (mModel == null){
            mModel = createModel();
        }
    }

    //获取mFragment
    public T getView(){
        return mFragment;
    }

    public void detachView(){
        mFragment = null;
    }

    protected abstract M createModel();
}
