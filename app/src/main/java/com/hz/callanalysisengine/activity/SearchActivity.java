package com.hz.callanalysisengine.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import com.hz.callanalysisengine.R;
import com.hz.callanalysisengine.adapter.SearchViewAdapter;
import com.hz.callanalysisengine.bean.SearchItem;
import com.hz.callanalysisengine.holder.SearchViewHolder;
import com.hz.callanalysisengine.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private SearchView mSearchView;
    private ListView mListView;
    private List<SearchItem> mSearchMessageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        init();

        setSearchView();
    }

    private void setAdapter() {
        SearchItem item = new SearchItem();
        item.setCallName("我爱渡边曜");
        item.setSinger("sks是我老婆");
        item.setCallID("520");
        for(int i = 0; i < 10; i++) {
            mSearchMessageList.add(item);
        }
        SearchViewAdapter adapter = new SearchViewAdapter(this,mSearchMessageList);
        mListView.setAdapter(adapter);
    }

    private void init() {
        mListView = (ListView) findViewById(R.id.lv_search);
        mSearchMessageList = new ArrayList<SearchItem>();
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
                Log.v("hz",query);
                setAdapter();
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
