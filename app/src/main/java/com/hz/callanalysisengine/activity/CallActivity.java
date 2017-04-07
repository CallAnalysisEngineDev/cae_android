package com.hz.callanalysisengine.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;

import com.hz.callanalysisengine.Fragment.CallMainFragment;
import com.hz.callanalysisengine.Fragment.CallMessageFragment;
import com.hz.callanalysisengine.R;

import com.hz.callanalysisengine.bean.CallMessageBean;
import com.hz.callanalysisengine.constant.Constant;
import com.hz.callanalysisengine.interfaces.ICallRetrofit;
import com.hz.callanalysisengine.interfaces.IMessageListener;
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

public class CallActivity extends FragmentActivity {

    private IMessageListener mListener;
    private ViewPager mViewPager;
    private CallMessageBean mCallMessageBean;

    private List<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        initView();
        initPager();
        setData();
    }


    // 初始化控件
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.vp_call);
    }

    // 设置fragment界面
    private void initPager() {
        CallMessageFragment f1 = new CallMessageFragment();
        CallMainFragment f2 = new CallMainFragment();

        list.add(f1);
        list.add(f2);
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("歌曲详情", CallMessageFragment.class)
                .add("call表内容", CallMainFragment.class).create());
        mViewPager.setAdapter(adapter);
        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setBackgroundColor(getResources().getColor(R.color.aqourColor));
        viewPagerTab.setViewPager(mViewPager);
    }

    // 请求数据
    private void setData() {
        Retrofit retrofit = RetrofitUtil.createRetrofit(Constant.BASE_URL);
        ICallRetrofit callRetrofit = retrofit.create(ICallRetrofit.class);
        Log.v("hz", Constant.BASE_URL + "detail?song.songId=" + getIntent().getStringExtra("id"));
        Call<CallMessageBean> call = callRetrofit.getCallResult("detail?song.songId=" +
                getIntent().getStringExtra("id"));
        call.enqueue(new Callback<CallMessageBean>() {
            @Override
            public void onResponse(Call<CallMessageBean> call, Response<CallMessageBean> response) {
                Log.v("hz", "请求成功");
                mCallMessageBean = response.body();
            }

            @Override
            public void onFailure(Call<CallMessageBean> call, Throwable t) {
                Log.v("hz", "请求失败" + t);
            }
        });
    }


    // 设置回调接口，接收activity传来的数据
    public CallMessageBean getMessage(){
       return mCallMessageBean;
    }

}
