package com.yangshikun.mvp.test;

import com.yangshikun.mvp.baseMVP.BaseFragPresenter;

/**
 * Created by yang.shikun on 2020/3/16 14:30
 */

public class AFragPresenter extends BaseFragPresenter<AFragment,AFragModel> {

    @Override
    protected AFragModel createModel() {
        return new AFragModel();
    }
}
