package com.hz.callanalysisengine.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hz.callanalysisengine.R;
import com.hz.callanalysisengine.adapter.SearchViewAdapter;
import com.hz.callanalysisengine.bean.SearchItemBean;
import com.hz.callanalysisengine.constant.Constant;
import com.hz.callanalysisengine.interfaces.IGetRetrofit;
import com.hz.callanalysisengine.util.RetrofitUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AllSongActivity extends AppCompatActivity {

    private ListView mSongLv;
    private SearchViewAdapter mAdapter;
    private List<SearchItemBean.ResultListBean> mAllSongList;   // 所有歌曲数据
    private int mAllPage;       // 总页面
    private int mTotalPage;     // 当前页面
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:     // 第一次加载
                    setAdapter();
                    break;
                case 2:     // 下拉分页加载
                    setMoreAdapter();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_song);
        initView();
        setSongData();
    }

    private void initView() {
        mSongLv = (ListView) findViewById(R.id.lv_all_song);
    }

    private void setSongData() {
        Retrofit retrofit = RetrofitUtil.createRetrofit(Constant.BASE_URL);
        IGetRetrofit mRetrofit = retrofit.create(IGetRetrofit.class);
        Call<SearchItemBean> call = mRetrofit.getSearchResult("search?page=1&songName=");
        call.enqueue(new Callback<SearchItemBean>() {
            @Override
            public void onResponse(Call<SearchItemBean> call, Response<SearchItemBean> response) {
                Log.v("hz","请求成功");
                SearchItemBean all = response.body();
                if (all.isSuccessed()) {
                    //  总页面
                    mAllPage = all.getTotalPage();
                    //  当前页面
                    mTotalPage = all.getNowPage();
                    mAllSongList = all.getResultList();
                    handler.sendEmptyMessage(1);
                }
            }

            @Override
            public void onFailure(Call<SearchItemBean> call, Throwable t) {
                Log.v("hz","请求失败");

            }
        });
    }


    private void setAdapter() {
        mAdapter = new SearchViewAdapter(this, mAllSongList);

        mSongLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AllSongActivity.this, CallActivity.class);
                intent.putExtra("id", mAllSongList.get(position).getSongId());
                intent.putExtra("html", mAllSongList.get(position).getSongName());
                startActivity(intent);
            }
        });
        mSongLv.setOnScrollListener(new AbsListView.OnScrollListener() {
            // scrollState滑动状态
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    // 当加载到最后一页时
                    if (view.getLastVisiblePosition() == view.getCount() - 1) {
                        if (mAllPage > mTotalPage) {
                            mTotalPage = mTotalPage + 1;
                            setMoreView(mTotalPage);
                        }
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }
        });
        mSongLv.setAdapter(mAdapter);
    }


    private void setMoreAdapter() {
        mAdapter.notifyDataSetChanged();
    }

    // 根据页数多次访问后台
    private void setMoreView(int page) {
        Retrofit retrofit = RetrofitUtil.createRetrofit(Constant.BASE_URL);
        IGetRetrofit mRetrofit = retrofit.create(IGetRetrofit.class);
        Call<SearchItemBean> call = mRetrofit.getSearchResult("search?page=" + page + "&song.songName=");
        call.enqueue(new Callback<SearchItemBean>() {
            @Override
            public void onResponse(Call<SearchItemBean> call, Response<SearchItemBean> response) {
                Log.v("hz", "请求更多成功");
                SearchItemBean all = response.body();
                mAllSongList.addAll(all.getResultList());
                handler.sendEmptyMessage(2);
            }

            @Override
            public void onFailure(Call<SearchItemBean> call, Throwable t) {
                Log.v("hz", "请求更多失败" + t);
            }
        });
    }
}
