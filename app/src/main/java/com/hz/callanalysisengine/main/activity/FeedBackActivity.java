package com.hz.callanalysisengine.main.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.hz.callanalysisengine.R;
import com.hz.callanalysisengine.bean.FeedBackBean;
import com.hz.callanalysisengine.bean.SuccessBean;
import com.hz.callanalysisengine.constant.Constant;
import com.hz.callanalysisengine.interfaces.IPostRetrofit;
import com.hz.callanalysisengine.main.base.BaseActivity;
import com.hz.callanalysisengine.util.ActivityUtil;
import com.hz.callanalysisengine.util.RetrofitUtil;
import com.hz.callanalysisengine.util.ToastUtil;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FeedBackActivity extends BaseActivity {

    private EditText mTitleEdt;
    private EditText mDetailEdt;
    private Button mPostBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        setClick();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_feed_back;
    }

    private void initView() {
        mTitleEdt = (EditText) findViewById(R.id.feedback_title_edt);
        mDetailEdt = (EditText) findViewById(R.id.feedback_detail_edt);
        mPostBtn = (Button) findViewById(R.id.feedback_post_btn);
    }

    // 填充反馈数据
    private FeedBackBean getData() {
        FeedBackBean bean = new FeedBackBean();
        bean.setType("1");
        bean.set_$MailTitle64(mTitleEdt.getText().toString());
        bean.set_$MailContent269(mDetailEdt.getText().toString());
        return bean;
    }

    // post请求
    private void post(FeedBackBean bean) {

        // 通过Gson将Bean转化为Json字符串形式
        Gson gson=new Gson();
        String route= gson.toJson(bean);

        Retrofit retrofit = RetrofitUtil.createRetrofit(Constant.BASE_URL);
        IPostRetrofit postRetrofit = retrofit.create(IPostRetrofit.class);
        RequestBody body= RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
        Call<SuccessBean> call = postRetrofit.messagePost("user/advice",body);
        call.enqueue(new Callback<SuccessBean>() {
            @Override
            public void onResponse(Call<SuccessBean> call, Response<SuccessBean> response) {
                Log.v("hz","请求成功"+response.body().isSuccessed());
                if(response.body().isSuccessed()) {
                    ToastUtil.showToast(FeedBackActivity.this,"发送成功");
                }
                else{
                    ToastUtil.showToast(FeedBackActivity.this,"发送失败");
                }
            }

            @Override
            public void onFailure(Call<SuccessBean> call, Throwable t) {
                Log.v("hz","失败"+t);
            }
        });
    }

    private void setClick(){
        mPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                post(getData());
            }
        });
    }


}
