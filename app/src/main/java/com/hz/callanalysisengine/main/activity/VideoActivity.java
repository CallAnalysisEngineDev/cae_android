package com.hz.callanalysisengine.main.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
        WebSettings webSettings = webView.getSettings();

        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setJavaScriptEnabled(true);


        webSettings.setAllowFileAccess(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        // 开启支持视频
        webSettings.setPluginState(WebSettings.PluginState.ON);
        webSettings.setGeolocationEnabled(true);
        // 开启DOM缓存。
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setDatabasePath(getApplicationContext().getCacheDir()
                .getAbsolutePath());
        webSettings.setAppCacheEnabled(true);
        webSettings.setAppCachePath(getApplicationContext().getCacheDir()
                .getAbsolutePath());
        webSettings.setAppCacheMaxSize(Integer.MAX_VALUE);
        webView.requestFocus();
    }

    private void setData() {
        Log.v("hz",Constant.BILIBILI_URL+getIntent().getStringExtra("video"));
        webView.loadUrl(Constant.BILIBILI_URL+getIntent().getStringExtra("video"));
    }
}
