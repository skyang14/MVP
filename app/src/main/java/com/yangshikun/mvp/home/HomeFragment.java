package com.yangshikun.mvp.home;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.yangshikun.mvp.R;
import com.yangshikun.mvp.baseMVP.BaseFragment;

import butterknife.BindView;

/**
 * Created by yang.shikun on 2020/3/17 11:31
 */

public class HomeFragment extends BaseFragment<HomePresenter> {
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.bt)
    Button bt;
    @BindView(R.id.bt_go)
    Button bt_go2Fragment;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //将业务交给presenter处理
                mPresenter.showToast();
            }
        });
        bt_go2Fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.go2Fragment();
            }
        });
    }

    //View层处理View,可供presenter调用
    public void showTextResult(String string) {
        //只负责显示Presenter处理的结果，不关心处理过程
        tv.setText(string);
        ToastUtils.showShort(string);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }



    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter();
    }
}
