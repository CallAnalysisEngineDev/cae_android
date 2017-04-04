package com.hz.callanalysisengine.util;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kotori on 2017/4/3.
 * retrofit封装类
 */
public class RetrofitUtil {

    public static Retrofit createRetrofit(String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
