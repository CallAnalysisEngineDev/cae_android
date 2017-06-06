package com.hz.callanalysisengine.main.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hz.callanalysisengine.main.adapter.SearchViewAdapter;
import com.hz.callanalysisengine.constant.Constant;
import com.hz.callanalysisengine.interfaces.IGetRetrofit;
import com.hz.callanalysisengine.util.RetrofitUtil;
import com.hz.callanalysisengine.R;
import com.hz.callanalysisengine.bean.SearchItemBean;
import com.hz.callanalysisengine.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SearchActivity extends AppCompatActivity {

    private SearchView mSearchView;
    private ListView mListView;
    private SearchViewAdapter mAdapter;
    private List<SearchItemBean.ResultListBean> mSearchMessageList;
    private int mAllPage;       // 总页面
    private int mTotalPage;     // 当前页面
    private String mQuery;      // 用户输入的数据
    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what) {
                case 1:     // 第一次加载
                    setAdapter();
                    break;
                case 2:
                    ToastUtil.showToast(SearchActivity.this,"~(๑•́ ₃ •̀๑) 找不到您搜索的关键字");
                    break;
                case 3:     // 下拉分页加载
                    setMoreAdapter();
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

    // 初始化控件
    private void init() {
        mListView = (ListView) findViewById(R.id.lv_search);
        mSearchMessageList = new ArrayList<>();
    }

    // 分页加载数据时，配置该adapter
    private void setMoreAdapter() {
        mAdapter = new SearchViewAdapter(this,mSearchMessageList);
        mListView.setAdapter(mAdapter);
    }

    // 配置初始adapter
    private void setAdapter() {

        mAdapter = new SearchViewAdapter(this,mSearchMessageList);

        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SearchActivity.this,CallActivity.class);
                intent.putExtra("id",mSearchMessageList.get(position).getSongId());
                intent.putExtra("html",mSearchMessageList.get(position).getSongName());
                startActivity(intent);
            }
        });
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            // scrollState滑动状态
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    // 当加载到最后一页时
                    if (view.getLastVisiblePosition() == view.getCount() - 1) {
                        if(mAllPage>mTotalPage) {
                            mTotalPage = mTotalPage+1;
                            setMoreView(mTotalPage);
                        }
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }
        });

    }

    // 设置搜索框并第一次访问后台
    private void setSearchView() {
        mSearchView = (SearchView) findViewById(R.id.search_view);
        // 设置默认打开搜索框
        mSearchView.setIconifiedByDefault(false);
        mSearchView.setQueryHint("请输入歌曲名称");
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            // 当搜索按钮点击后调用方法
            public boolean onQueryTextSubmit(String query) {
                Retrofit retrofit = RetrofitUtil.createRetrofit(Constant.CALL_URL);
                IGetRetrofit mRetrofit = retrofit.create(IGetRetrofit.class);
                mQuery = query;
                Call<SearchItemBean> call = mRetrofit.getSearchResult("search?page=1&songName="+query);

                call.enqueue(new Callback<SearchItemBean>() {
                    @Override
                    public void onResponse(Call<SearchItemBean> call, Response<SearchItemBean> response) {
                        Log.v("hz","请求成功");
                        SearchItemBean all = response.body();
                        // 判断是否查询到结果
                        if(all.isSuccessed()){
                            //  总页面
                                mAllPage = all.getTotalPage();
                            //  当前页面
                                mTotalPage = all.getNowPage();
                                mSearchMessageList = all.getResultList();
                                handler.sendEmptyMessage(1);
                        }
                        else{
                            handler.sendEmptyMessage(2);
                        }
                    }

                    @Override
                    public void onFailure(Call<SearchItemBean> call, Throwable t) {
                        Log.v("hz","请求失败"+t);
                    }
                });
                return true;
            }
            // 当搜索内容状态改变后调用方法
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    // 根据页数多次访问后台
    private void setMoreView(int page){
        Retrofit retrofit = RetrofitUtil.createRetrofit(Constant.CALL_URL);
        IGetRetrofit mRetrofit = retrofit.create(IGetRetrofit.class);
        Call<SearchItemBean> call = mRetrofit.getSearchResult("search?page="+page+"&song.songName="+mQuery);
        call.enqueue(new Callback<SearchItemBean>() {
            @Override
            public void onResponse(Call<SearchItemBean> call, Response<SearchItemBean> response) {
                Log.v("hz","请求更多成功");
                SearchItemBean all = response.body();
                mSearchMessageList.addAll(all.getResultList());
                handler.sendEmptyMessage(3);
            }

            @Override
            public void onFailure(Call<SearchItemBean> call, Throwable t) {
                Log.v("hz","请求更多失败"+t);
            }
        });
    }


}
