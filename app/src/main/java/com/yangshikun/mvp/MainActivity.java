package com.yangshikun.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yangshikun.mvp.baseMVP.BaseActivity;
import com.yangshikun.mvp.home.HomeFragment;

//View层，展示层
public class MainActivity extends BaseActivity<MainPresenter> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadRootFragment(R.id.fragment_container,new HomeFragment());

    }




    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }
}
