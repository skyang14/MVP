package com.yangshikun.mvp.test;

import com.yangshikun.mvp.baseMVP.BaseModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yang.shikun on 2020/3/16 14:30
 */

public class AFragModel extends BaseModel {

    public List<String> provideList() {
        ArrayList stringList = new ArrayList();
        stringList.add("大家好");
        stringList.add("我是VAE");
        stringList.add("这是我的首张独唱专辑");
        stringList.add("自定义");
        stringList.add("谱曲编曲都是我自己");
        stringList.add("希望大家都开心每一天");
        return stringList;
    }
}
