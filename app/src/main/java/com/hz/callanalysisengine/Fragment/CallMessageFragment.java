package com.hz.callanalysisengine.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hz.callanalysisengine.activity.CallActivity;
import com.hz.callanalysisengine.activity.VideoActivity;
import com.hz.callanalysisengine.bean.CallMessageBean;
import com.hz.callanalysisengine.constant.Constant;
import com.hz.callanalysisengine.R;
import com.hz.callanalysisengine.util.ToastUtil;
import com.squareup.picasso.Picasso;

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
    private String htmlUrl;


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
        new Thread(){
            public void run(){
                while (true){
                    if (((CallActivity) getActivity()).getMessage()!=null) {
                        break;
                    }
                }
                    Message msg = new Message();
                    msg.what = 1;
                    msg.obj = ((CallActivity)getActivity()).getMessage();
                    handler.sendMessage(msg);
            }
        }.start();

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
                    .load(callMessage.getResult().getSong().getSongCover())
                    .into(callImg);
            htmlUrl = callMessage.getResult().getCallSource();
            videoUrl = callMessage.getResult().getSong().getSongVideo();
            if(Integer.valueOf(videoUrl)==0){                   // 做视频是否存在的判断
                mVideoBtn.setBackgroundColor(Color.GRAY);
                mVideoBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showToast(getActivity(),"该歌曲的视频教学尚未完成哦");
                    }
                });
            }
            else{
                setClick();
            }
        }

    }




}
