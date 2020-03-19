package com.yangshikun.mvp.test;

import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jakewharton.rxbinding3.view.RxView;
import com.yangshikun.mvp.R;
import com.yangshikun.mvp.baseMVP.BaseFragment;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.functions.Consumer;

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
        addDisposable(RxView.clicks(btAdd)
                .throttleFirst(1, TimeUnit.SECONDS) //设置1秒内只响应首次（throttleFirst）或者末次（throttleLast）的点击事件，windowDuration为防抖时间
                .subscribe((Consumer<Object>) o ->
                        adapter.addList(mPresenter.getStringList())));
        //RxBinding对view的控制很强大，详情可以搜RxBinding的具体使用
       /* btAdd.setOnClickListener(v -> {
            adapter.addList(mPresenter.getStringList());
        });*/
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
