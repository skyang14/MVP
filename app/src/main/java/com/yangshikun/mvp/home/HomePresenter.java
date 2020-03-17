package com.yangshikun.mvp.home;

import com.blankj.utilcode.util.ToastUtils;
import com.yangshikun.mvp.test.AFragment;
import com.yangshikun.mvp.baseMVP.BaseFragPresenter;

/**
 * Created by yang.shikun on 2020/3/17 11:31
 */

public class HomePresenter extends BaseFragPresenter<HomeFragment,HomeModel> {
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
}
