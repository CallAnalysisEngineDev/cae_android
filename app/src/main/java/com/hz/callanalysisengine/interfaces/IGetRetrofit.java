package com.hz.callanalysisengine.interfaces;

import com.hz.callanalysisengine.bean.CallMessageBean;
import com.hz.callanalysisengine.bean.MainDataBean;
import com.hz.callanalysisengine.bean.SearchItemBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by kotori on 2017/4/3.
 * 请求call表详情的接口
 */
public interface IGetRetrofit {

    // 获取Call表信息
    @GET()
    Call<CallMessageBean> getCallResult(@Url() String ip);
    // 获取主页数据
    @GET()
    Call<MainDataBean> getMainData(@Url() String ip);
    // 获取搜索结果
    @GET()
    Call<SearchItemBean> getSearchResult(@Url() String ip);
}
