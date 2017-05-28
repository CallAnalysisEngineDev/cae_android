package com.hz.callanalysisengine.activity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hz.callanalysisengine.R;
import com.hz.callanalysisengine.adapter.SettingAdapter;
import com.hz.callanalysisengine.util.DataCleanUtil;
import com.hz.callanalysisengine.util.ToastUtil;
import com.iflytek.autoupdate.IFlytekUpdate;
import com.iflytek.autoupdate.IFlytekUpdateListener;
import com.iflytek.autoupdate.UpdateConstants;
import com.iflytek.autoupdate.UpdateErrorCode;
import com.iflytek.autoupdate.UpdateInfo;
import com.iflytek.autoupdate.UpdateType;

import java.util.ArrayList;
import java.util.List;

public class SettingActivity extends AppCompatActivity {

    private Context mContext;
    private IFlytekUpdate updManager;   // 三方自动更新

    private ListView settingListView;
    private List<String> settingItemList;
    private List<String> settingCodeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        mContext = this.getApplicationContext();
        initView();
        initData();
        setAdapter();
        autoUpdate();
    }

    private void initView() {
        settingListView = (ListView) findViewById(R.id.lv_setting);
    }

    private void initData() {
        settingItemList = new ArrayList<>();
        settingItemList.add("版本号");
        settingItemList.add("检查更新");
        settingItemList.add("清除缓存");

        settingCodeList = new ArrayList<>();
        // 获取本机版本号
        try {
            PackageManager manager = mContext.getPackageManager();
            PackageInfo info = manager.getPackageInfo(mContext.getPackageName(), 0);
            settingCodeList.add("" + info.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 2; i++) {
            settingCodeList.add("");
        }
    }

    // 加载数据适配器
    private void setAdapter() {
        SettingAdapter adapter = new SettingAdapter(this, settingItemList, settingCodeList);
        settingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch ((int) id) {
                    case 1:
                        updManager.setParameter(UpdateConstants.EXTRA_STYLE, UpdateConstants.UPDATE_UI_DIALOG);
                        updManager.forceUpdate(SettingActivity.this, updateListener);
                        break;
                    case 2:
                        DataCleanUtil.cleanInternalCache(SettingActivity.this);
                        DataCleanUtil.cleanExternalCache(SettingActivity.this);
                        DataCleanUtil.cleanDatabases(SettingActivity.this);
                        DataCleanUtil.cleanSharedPreference(SettingActivity.this);
                        DataCleanUtil.cleanFiles(SettingActivity.this);
                        ToastUtil.showToast(SettingActivity.this, "清除缓存成功");
                        break;
                }
            }
        });
        settingListView.setAdapter(adapter);
    }

    // 初始化自动更新功能
    private void autoUpdate(){

        updManager = IFlytekUpdate.getInstance(mContext);
        updManager.setDebugMode(true);
        updManager.setParameter(UpdateConstants.EXTRA_WIFIONLY, "true");
        // 设置通知栏icon，默认使用SDK默认
        updManager.setParameter(UpdateConstants.EXTRA_NOTI_ICON, "false");
    }

    // 设置更新回调接口
    private IFlytekUpdateListener updateListener = new IFlytekUpdateListener() {

        @Override
        public void onResult(int errorcode, UpdateInfo result) {

            if(errorcode == UpdateErrorCode.OK && result!= null) {
                if(result.getUpdateType() == UpdateType.NoNeed) {
                    ToastUtil.showToast(SettingActivity.this,"已经是最新的版本了");
                    return;
                }
                updManager.showUpdateInfo(SettingActivity.this, result);
            }
            else
            {
                ToastUtil.showToast(SettingActivity.this,"更新失败");
            }
        }
    };
}
