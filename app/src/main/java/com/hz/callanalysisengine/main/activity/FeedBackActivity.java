package com.hz.callanalysisengine.main.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.hz.callanalysisengine.R;
import com.hz.callanalysisengine.bean.CallMessageBean;
import com.hz.callanalysisengine.bean.FeedBackBean;
import com.hz.callanalysisengine.bean.SuccessBean;
import com.hz.callanalysisengine.constant.Constant;
import com.hz.callanalysisengine.interfaces.IGetRetrofit;
import com.hz.callanalysisengine.interfaces.IPostRetrofit;
import com.hz.callanalysisengine.main.base.BaseActivity;
import com.hz.callanalysisengine.util.ActivityUtil;
import com.hz.callanalysisengine.util.RetrofitUtil;
import com.hz.callanalysisengine.util.ToastUtil;

import java.util.HashMap;
import java.util.Map;

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
    private Map getData() {

        // 通过表单，把需要上传的反馈信息放入Map提交
        Map<String,Object> map = new HashMap<>();
        map.put("type",1);
        map.put("mail.title",mTitleEdt.getText().toString());
        map.put("mail.content",mDetailEdt.getText().toString());

        return map;
    }



    // 上传邮件内容
    private void post(Map<String,Object> map) {

        Retrofit retrofit = RetrofitUtil.createRetrofit(Constant.BASE_URL);
        IPostRetrofit postRetrofit = retrofit.create(IPostRetrofit.class);

        Call<SuccessBean> call = postRetrofit.messagePost("user/advice",map);
        call.enqueue(new Callback<SuccessBean>() {
            @Override
            public void onResponse(Call<SuccessBean> call, Response<SuccessBean> response) {
                if (response.body()!=null){
                    Log.v("hz","请求成功"+response.body().isSuccessed());
                    if(response.body().isSuccessed()) {
                        ToastUtil.showToast(FeedBackActivity.this,"发送成功");
                    }
                    else{
                        Log.v("hz",response.body().getErrInfo());
                        ToastUtil.showToast(FeedBackActivity.this,"发送失败");
                    }
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
                mPostBtn.setBackgroundColor(Color.GRAY);
                mPostBtn.setClickable(false);
            }
        });
    }


}
