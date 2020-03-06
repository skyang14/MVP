package com.yangshikun.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yangshikun.mvp.baseMVP.BaseActivity;

//View层，展示层
public class MainActivity extends BaseActivity<MainPresenter> {
    private TextView tv;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        bt = (Button) findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //将业务交给presenter处理
                mPresenter.showToast();
            }
        });
    }

    //View层处理View,可供presenter调用
    public void showTextResult(String string){
        //只负责显示Presenter处理的结果，不关心处理过程
        tv.setText(string);
        Toast.makeText(this,string,Toast.LENGTH_SHORT).show();
    }


    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }
}
