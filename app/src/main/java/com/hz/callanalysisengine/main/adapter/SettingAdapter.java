package com.hz.callanalysisengine.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hz.callanalysisengine.R;

import java.util.List;

/**
 * Created by kotori on 2017/4/9.
 * 设置界面适配器
 */
public class SettingAdapter extends BaseAdapter{

    private List<String> mlist;
    private List<String> mlistVersion;
    private Context mContext;

    public SettingAdapter(Context context,List<String> list,List<String> ver) {
        this.mContext = context;
        this.mlist = list;
        mlistVersion = ver;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_setting_view,parent,false);
        TextView tv_setting = (TextView) convertView.findViewById(R.id.tv_item_setting);
        TextView tv_verison = (TextView) convertView.findViewById(R.id.tv_item_setting_gone);
        tv_setting.setText(mlist.get(position));
        tv_verison.setText(mlistVersion.get(position));

        return convertView;
    }
}
