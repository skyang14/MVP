package com.yangshikun.mvp.test;

import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yangshikun.mvp.R;
import com.yangshikun.mvp.baseMVP.BaseFragment;

import butterknife.BindView;

/**
 * Created by yang.shikun on 2020/3/16 14:29
 */

public class AFragment extends BaseFragment<AFragPresenter> {
    @BindView(R.id.bt_add)
    Button btAdd;
    @BindView(R.id.rv)
    RecyclerView recyclerView;

    @Override
    protected void initData() {
    }

    @Override
    protected void initView(View view) {
        Adapter adapter = new Adapter(getContext(),mPresenter.getStringList());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        btAdd.setOnClickListener(v -> {
            adapter.addList(mPresenter.getStringList());
        });
    }


    @Override
    protected int getLayoutId() {
        return R.layout.frament_a;
    }

    @Override
    public AFragPresenter createPresenter() {
        return new AFragPresenter();
    }


}
