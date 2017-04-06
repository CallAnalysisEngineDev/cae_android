package com.hz.callanalysisengine.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hz.callanalysisengine.activity.VideoActivity;
import com.hz.callanalysisengine.bean.CallMessageBean;
import com.hz.callanalysisengine.constant.Constant;
import com.hz.callanalysisengine.interfaces.ICallRetrofit;
import com.hz.callanalysisengine.util.RetrofitUtil;
import com.hz.callanalysisengine.R;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by kotori on 2017/4/3.
 * call表信息的页面
 */
public class CallMessageFragment extends Fragment{

    private TextView songName;
    private TextView singer;
    private TextView callVersion;
    private TextView saleTime;
    private TextView updateTime;
    private ImageView callImg;
    private Button mVideoBtn;
    private String videoUrl;


    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what) {
                case 1 :
                    updateView((CallMessageBean)msg.obj);
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_call_message,container,false);
        initView(view);
        setData();
        setClick();
        return view;
    }



    // 初始化控件
    private void initView(View view) {
        songName = (TextView) view.findViewById(R.id.tv_call_song_name);
        singer = (TextView) view.findViewById(R.id.tv_call_message_singer);
        callVersion = (TextView) view.findViewById(R.id.tv_call_message_version);
        saleTime = (TextView) view.findViewById(R.id.tv_call_message_saletime);
        updateTime = (TextView) view.findViewById(R.id.tv_call_message_updatetime);
        callImg = (ImageView) view.findViewById(R.id.iv_call_message_img);
        mVideoBtn = (Button) view.findViewById(R.id.btn_call_video);
    }

    // 设置监听事件
    private void setClick() {
        mVideoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),VideoActivity.class);
                intent.putExtra("video",videoUrl);
                startActivity(intent);
            }
        });
    }

    // 请求数据
    private void setData() {
        Retrofit retrofit = RetrofitUtil.createRetrofit(Constant.BASE_URL);
        ICallRetrofit callRetrofit = retrofit.create(ICallRetrofit.class);
        Log.v("hz",Constant.BASE_URL+"detail?song.songId="+getActivity().getIntent().getStringExtra("id"));
        Call<CallMessageBean> call = callRetrofit.getCallResult("detail?song.songId="+
                getActivity().getIntent().getStringExtra("id"));
        call.enqueue(new Callback<CallMessageBean>() {
            @Override
            public void onResponse(Call<CallMessageBean> call, Response<CallMessageBean> response) {
                Log.v("hz","请求成功");
                CallMessageBean callMessage = response.body();
                Message msg = new Message();
                msg.what = 1;
                msg.obj = callMessage;
                handler.sendMessage(msg);
            }

            @Override
            public void onFailure(Call<CallMessageBean> call, Throwable t) {
                Log.v("hz","请求失败"+t);
            }
        });
    }

    // 更新界面
    private void updateView(CallMessageBean callMessage) {
        if(callMessage!=null) {
            updateTime.setText(callMessage.getResult().getSong().getSongLastModifyTime());
            singer.setText(callMessage.getResult().getSong().getSongOwner());
            callVersion.setText(callMessage.getResult().getCallVersion()+"");
            saleTime.setText(callMessage.getResult().getSong().getSongSellTime());
            songName.setText(callMessage.getResult().getSong().getSongName());
            Picasso.with(getActivity())
                    .load(Constant.IMG_URL +callMessage.getResult().getSong().getSongCover())
                    .into(callImg);
            videoUrl = callMessage.getResult().getSong().getSongVideo();
        }

    }


}
