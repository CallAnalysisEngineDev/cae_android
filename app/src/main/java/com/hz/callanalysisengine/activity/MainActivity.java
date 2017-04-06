package com.hz.callanalysisengine.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.hz.callanalysisengine.R;
import com.hz.callanalysisengine.adapter.HotCallViewAdapter;
import com.hz.callanalysisengine.adapter.MainItemAdapter;
import com.hz.callanalysisengine.adapter.NewCallViewAdapter;
import com.hz.callanalysisengine.adapter.SideMenuAdapter;
import com.hz.callanalysisengine.bean.MainDataBean;
import com.hz.callanalysisengine.constant.Constant;
import com.hz.callanalysisengine.interfaces.IMainDataRetrofit;
import com.hz.callanalysisengine.interfaces.IhotRVItemListener;
import com.hz.callanalysisengine.util.ActivityUtil;
import com.hz.callanalysisengine.util.RetrofitUtil;
import com.hz.callanalysisengine.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    private ListView mSideMenuListview;                 //侧栏listview
    private List<String> mSideData;                     //侧栏列表名称

    private GridView mItemGridView;                     //item的GridView
    private List<String> mItemData;                     //item名称
    private List<Integer> mItemImg;                     //item图标

    private RecyclerView mHotRecyclerView;              //热门歌曲的RecyclerView
    private List<MainDataBean.RedBean> mHotbean;        //热门歌曲

    private GridView mNewGridView;                      //最近更新的GridView
    private List<MainDataBean.NewestBean> mNewbean;     //最近更新

    // 设置toolbar菜单点击事件
    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_search:
                    Log.v("hz","搜索");
                    ActivityUtil.startActivity(MainActivity.this,SearchActivity.class,false);
                    break;
            }
            return true;
        }
    };

    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what) {
                case 1 :
                    setHotAdapter();
                    setNewAdapter();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getData();
        setToolbar();
        setSideAdapter();
        setItemAdapter();
    }




    // 初始化控件
    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.main_toolBar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_main);
        mSideMenuListview = (ListView) findViewById(R.id.lv_side_menu);
        mItemGridView = (GridView) findViewById(R.id.gv_main_item);
        mHotRecyclerView = (RecyclerView) findViewById(R.id.rv_main_hot);
        mNewGridView = (GridView) findViewById(R.id.gv_main_new);
    }

    // 设置toolbar
    private void setToolbar() {
        setSupportActionBar(mToolbar);
        mToolbar.setOnMenuItemClickListener(onMenuItemClick);

        // 设置返回键可用
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    // 设置menu菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    
    // 请求网络
    private void getData(){
        IMainDataRetrofit retrofit= RetrofitUtil.createRetrofit(Constant.BASE_URL)
                .create(IMainDataRetrofit.class);
        Call<MainDataBean> call = retrofit.getCallResult("");
        call.enqueue(new Callback<MainDataBean>() {
            @Override
            public void onResponse(Call<MainDataBean> call, Response<MainDataBean> response) {
                Log.v("hz","请求成功");
                MainDataBean data = response.body();
                if(data.isSuccessed()) {
                    Log.v("hz","数据接收成功");
                    mHotbean = data.getRed();
                    mNewbean = data.getNewest();
                    handler.sendEmptyMessage(1);
                }
                else{
                    Log.v("hz","数据接收失败");
                    mHotbean = new ArrayList<MainDataBean.RedBean>();
                    mNewbean = new ArrayList<MainDataBean.NewestBean>();
                }
            }

            @Override
            public void onFailure(Call<MainDataBean> call, Throwable t) {
                Log.v("hz","请求失败"+t);
            }
        });
    }

    // 设置侧栏数据
    private void setSideAdapter() {
        mSideData = new ArrayList<>();
        mSideData.add("关于我们");
        mSideData.add("设置");
        SideMenuAdapter adapter = new SideMenuAdapter(MainActivity.this,mSideData);
        mSideMenuListview.setAdapter(adapter);
        mSideMenuListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch ((int) id) {
                    case 0 :
                        ToastUtil.showToast(MainActivity.this,"关于我们");
                        break;
                    case 1 :
                        ToastUtil.showToast(MainActivity.this,"设置");
                        break;
                }
            }
        });
    }

    // 设置item模块数据
    private void setItemAdapter() {
        mItemData = new ArrayList<>();
        mItemData.add("所有歌单");
        mItemData.add("BD系列");
        mItemData.add("小队系列");
        mItemImg = new ArrayList<>();
        mItemImg.add(R.mipmap.img_test_chika);
        mItemImg.add(R.mipmap.img_test_you);
        mItemImg.add(R.mipmap.img_test_riko);
        MainItemAdapter adapter = new MainItemAdapter(MainActivity.this,mItemData,mItemImg);
        mItemGridView.setAdapter(adapter);
    }

    // 设置热门歌曲数据
    private void setHotAdapter() {
        HotCallViewAdapter adapter = new HotCallViewAdapter(MainActivity.this,mHotbean);
        adapter.setItemOnClickListener(new IhotRVItemListener() {
            @Override
            public void onItemOnClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this,CallActivity.class);
                intent.putExtra("id",mHotbean.get(position).getSongId());
                intent.putExtra("html",mHotbean.get(position).getSongName());
                startActivity(intent);
            }
        });
        mHotRecyclerView.setAdapter(adapter);
        mHotRecyclerView.setLayoutManager(new GridLayoutManager(this,1,GridLayoutManager.HORIZONTAL,false));
    }

    // 设置最新歌曲数据
    private void setNewAdapter() {
        NewCallViewAdapter adapter = new NewCallViewAdapter(MainActivity.this,mNewbean);
        mNewGridView.setAdapter(adapter);
        mNewGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,CallActivity.class);
                intent.putExtra("id",mNewbean.get(position).getSongId());
                intent.putExtra("html",mNewbean.get(position).getSongName());
                startActivity(intent);
            }
        });
    }


}
