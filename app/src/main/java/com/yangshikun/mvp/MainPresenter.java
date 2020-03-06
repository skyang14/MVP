package com.yangshikun.mvp;

import com.yangshikun.mvp.baseMVP.BasePresenter;

/**逻辑处理层，可以调用View层和Model层
 * Created by yang.shikun on 2020/3/6 14:39
 */

public class MainPresenter extends BasePresenter<MainActivity,MainModel> {
    @Override
    protected MainModel createModel() {
        return new MainModel();
    }

    public void showToast(){
        getView().showTextResult(mModel.getStringFromModel());
    }
}
