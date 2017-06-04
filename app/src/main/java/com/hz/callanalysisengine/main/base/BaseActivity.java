package com.hz.callanalysisengine.main.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hz.callanalysisengine.R;


public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        initToolBar();
    }

    protected  void initToolBar(){
        mToolbar = (Toolbar) findViewById(R.id.main_toolBar);
        setSupportActionBar(mToolbar);
        // 添加返回键
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // 去除默认标题显示
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected abstract int getContentView();


}