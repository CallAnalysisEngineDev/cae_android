package com.hz.callanalysisengine.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.hz.callanalysisengine.R;
import com.hz.callanalysisengine.constant.Constant;

public class VideoActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        webView = (WebView) findViewById(R.id.wbv_video);
        setWebConfig();
        setData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webView.destroy();
    }

    private void setWebConfig() {
        WebSettings settings = webView.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
    }

    private void setData() {
        webView.loadUrl(Constant.BILIBILI_URL+getIntent().getStringExtra("video"));

    }
}
