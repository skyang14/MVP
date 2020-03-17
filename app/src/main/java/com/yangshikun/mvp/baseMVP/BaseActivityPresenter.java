package com.yangshikun.mvp.baseMVP;

/**逻辑处理层
 * Created by yang.shikun on 2020/3/6 14:41
 */

public abstract class BaseActivityPresenter<T extends BaseActivity, M extends BaseModel> implements IPresenter {
    protected T mActivity;
    protected M mModel;

    public void attachView(T activity){
        mActivity = activity;
        if (mModel == null){
            mModel = createModel();
        }
    }

    //获取mActivity
    public T getView(){
        return mActivity;
    }

    public void detachView(){
        mActivity = null;
    }

    protected abstract M createModel();
}
