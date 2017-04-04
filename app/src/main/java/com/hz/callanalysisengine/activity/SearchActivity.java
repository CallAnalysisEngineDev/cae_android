package com.hz.callanalysisengine.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hz.callanalysisengine.R;
import com.hz.callanalysisengine.adapter.SearchViewAdapter;
import com.hz.callanalysisengine.bean.SearchItemBean;
import com.hz.callanalysisengine.constant.Constant;
import com.hz.callanalysisengine.interfaces.ISearchRetrofit;
import com.hz.callanalysisengine.util.ActivityUtil;
import com.hz.callanalysisengine.util.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SearchActivity extends AppCompatActivity {

    private SearchView mSearchView;
    private ListView mListView;
    private List<SearchItemBean.ResultListBean> mSearchMessageList;
    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what) {
                case 1:
                    setAdapter();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        init();

        setSearchView();
    }

    private void setAdapter() {

        SearchViewAdapter adapter = new SearchViewAdapter(this,mSearchMessageList);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0 :
                        ActivityUtil.startActivity(SearchActivity.this,CallActivity.class,true);
                        break;
                }
            }
        });
    }

    private void init() {
        mListView = (ListView) findViewById(R.id.lv_search);
        mSearchMessageList = new ArrayList<>();
    }

    private void setSearchView() {
        mSearchView = (SearchView) findViewById(R.id.search_view);
        // 设置默认打开搜索框
        mSearchView.setIconifiedByDefault(false);
        mSearchView.setQueryHint("请输入歌曲名称");
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            // 当搜索按钮点击后调用方法
            public boolean onQueryTextSubmit(String query) {
                Retrofit retrofit = RetrofitUtil.createRetrofit(Constant.BASE_URL);
                ISearchRetrofit mRetrofit = retrofit.create(ISearchRetrofit.class);
                Call<SearchItemBean> call = mRetrofit.getSearchResult("search?page=1&song.songName="+query);

                call.enqueue(new Callback<SearchItemBean>() {
                    @Override
                    public void onResponse(Call<SearchItemBean> call, Response<SearchItemBean> response) {
                        Log.v("hz","请求成功");
                        SearchItemBean all = response.body();
                        mSearchMessageList = all.getResultList();
                        handler.sendEmptyMessage(1);

                    }

                    @Override
                    public void onFailure(Call<SearchItemBean> call, Throwable t) {
                        Log.v("hz","请求失败"+t);
                    }
                });
//                setAdapter();
                return true;
            }
            // 当搜索内容状态改变后调用方法
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }


}
