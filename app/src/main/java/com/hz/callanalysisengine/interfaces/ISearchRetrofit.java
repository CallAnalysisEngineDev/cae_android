package com.hz.callanalysisengine.interfaces;

import com.hz.callanalysisengine.bean.SearchItemBean;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by kotori on 2017/4/3.
 */
public interface ISearchRetrofit {
    @GET()
    Call<SearchItemBean> getSearchResult(@Url() String ip);
}
