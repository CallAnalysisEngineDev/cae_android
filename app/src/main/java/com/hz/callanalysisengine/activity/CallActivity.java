package com.hz.callanalysisengine.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;

import com.hz.callanalysisengine.Fragment.CallMainFragment;
import com.hz.callanalysisengine.Fragment.CallMessageFragment;
import com.hz.callanalysisengine.R;
import com.hz.callanalysisengine.adapter.TabsAdapter;
import com.hz.callanalysisengine.bean.CallMessageBean;
import com.hz.callanalysisengine.constant.Constant;
import com.hz.callanalysisengine.interfaces.ICallRetrofit;
import com.hz.callanalysisengine.util.RetrofitUtil;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CallActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager mViewPager;

    private List<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        initView();
        initPager();
    }




    // 初始化控件
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.vp_call);
        toolbar = (Toolbar) findViewById(R.id.main_toolBar);
        setSupportActionBar(toolbar);
    }

    // 设置fragment界面
    private void initPager() {
        CallMessageFragment f1 = new CallMessageFragment();
        CallMainFragment f2 = new CallMainFragment();

        list.add(f1);
        list.add(f2);
        FragmentPagerItemAdapter adapter  = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("歌曲详情",CallMessageFragment.class)
                .add("call表内容",CallMainFragment.class).create());
        mViewPager.setAdapter(adapter);
        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(mViewPager);
    }
}
