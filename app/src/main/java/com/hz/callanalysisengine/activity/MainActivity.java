package com.hz.callanalysisengine.activity;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.hz.callanalysisengine.R;
import com.hz.callanalysisengine.adapter.MainItemAdapter;
import com.hz.callanalysisengine.adapter.SideMenuAdapter;
import com.hz.callanalysisengine.util.ActivityUtil;
import com.hz.callanalysisengine.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mSideMenuListview;             //侧栏listview
    private List<String> mSideData;                 //侧栏列表名称
    private GridView mItemGridview;                 //item的GridView
    private List<String> mItemData;                     //item名称
    private List<Integer> mItemImg;                     //item图标

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setToolbar();
        setSideAdapter();
        setItemAdapter();
    }


    // 初始化控件
    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.main_toolBar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_main);
        mSideMenuListview = (ListView) findViewById(R.id.lv_side_menu);
        mItemGridview = (GridView) findViewById(R.id.gv_main_item);

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
        mItemGridview.setAdapter(adapter);
    }
}
