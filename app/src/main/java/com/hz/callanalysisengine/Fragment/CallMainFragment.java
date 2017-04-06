package com.hz.callanalysisengine.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.hz.callanalysisengine.constant.Constant;
import com.hz.callanalysisengine.R;

/**
 * Created by kotori on 2017/4/3.
 * call表信息的页面
 */
public class CallMainFragment extends Fragment{

    private WebView webView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_call_main,container,false);
        webView = (WebView) view.findViewById(R.id.wbv_call_main);
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
        webView.loadUrl(Constant.AQOURS_HTML_URL+getActivity()
                .getIntent().getStringExtra("html")+".html");

    }

}
