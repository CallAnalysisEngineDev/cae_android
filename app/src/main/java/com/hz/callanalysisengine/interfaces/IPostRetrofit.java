package com.hz.callanalysisengine.interfaces;

import com.hz.callanalysisengine.bean.SuccessBean;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by kotori on 2017/4/3.
 * post请求的接口
 */
public interface IPostRetrofit {
    @Headers({"Content-Type: application/json",
            "Accept: application/json"})     //需要添加头

    @POST
    Call<SuccessBean> messagePost(@Url String url, @Body RequestBody route);
}
