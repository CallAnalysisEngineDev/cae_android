package com.hz.callanalysisengine.interfaces;

import com.hz.callanalysisengine.bean.MainDataBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by kotori on 2017/4/6.
 * 请求首页数据的接口
 */
public interface IMainDataRetrofit {
    @GET()
    Call<MainDataBean> getCallResult(@Url() String ip);
}
