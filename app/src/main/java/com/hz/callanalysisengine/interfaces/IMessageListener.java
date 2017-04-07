package com.hz.callanalysisengine.interfaces;

import com.hz.callanalysisengine.bean.CallMessageBean;

import retrofit2.http.PUT;

/**
 * Created by kotori on 2017/4/7.
 * 详情界面fragment与activity传值
 */
public interface IMessageListener {

    public void onGetMessage(CallMessageBean bean);

}
