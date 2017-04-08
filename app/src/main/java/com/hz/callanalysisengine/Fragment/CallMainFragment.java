package com.hz.callanalysisengine.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.hz.callanalysisengine.activity.CallActivity;
import com.hz.callanalysisengine.bean.CallMessageBean;
import com.hz.callanalysisengine.constant.Constant;
import com.hz.callanalysisengine.R;

/**
 * Created by kotori on 2017/4/3.
 * call表信息的页面
 */
public class CallMainFragment extends Fragment {

    private ImageView falseView;
    private WebView webView;
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    updateView((CallMessageBean) msg.obj);
                    break;
            }
        }
    };

    private void updateView(CallMessageBean callMessage) {
        if (callMessage.getResult().getCallSource() != null) {
            String url = Constant.AQOURS_HTML_URL + callMessage.getResult().getCallSource();
            webView.loadUrl(url);
            webView.setVisibility(View.VISIBLE);
        } else {
            webView.setVisibility(View.GONE);
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_call_main, container, false);
        webView = (WebView) view.findViewById(R.id.wbv_call_main);
        falseView = (ImageView) view.findViewById(R.id.iv_call_main_false);
        setWebConfig();
        setData();
        return view;
    }


    private void setWebConfig() {
        WebSettings settings = webView.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
    }

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
                msg.obj = ((CallActivity) getActivity()).getMessage();
                handler.sendMessage(msg);
            }
        }.start();



    }

}
