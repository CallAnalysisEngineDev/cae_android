package com.hz.callanalysisengine.interfaces;

import com.hz.callanalysisengine.bean.SuccessBean;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by kotori on 2017/4/3.
 * post请求的接口
 */
public interface IPostRetrofit {
    @Headers({"Content-Type: application/x-www-form-urlencoded",
            "Accept: application/json"})     //需要添加头

    @FormUrlEncoded
    @POST
    Call<SuccessBean> messagePost(@Url String url, @FieldMap Map<String,Object> params);
}
