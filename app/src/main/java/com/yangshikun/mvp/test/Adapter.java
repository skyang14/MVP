package com.yangshikun.mvp.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.yangshikun.mvp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yang.shikun on 2020/3/19 9:33
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<String> stringList = new ArrayList<>();
    private Context context;

    public Adapter(Context context,List<String> list) {
        stringList.addAll(list);
        this.context = context;
    }

    public void setList(List<String> list){
        stringList.clear();
        stringList.addAll(list);
        notifyDataSetChanged();
    }


    public void addList(List<String> list){
        stringList.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv.setText(stringList.get(position));
        holder.tv.setOnClickListener(v -> {
            ToastUtils.showShort(holder.tv.getText());
        });
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv)
        ImageView iv;
        @BindView(R.id.tv_text)
        TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
