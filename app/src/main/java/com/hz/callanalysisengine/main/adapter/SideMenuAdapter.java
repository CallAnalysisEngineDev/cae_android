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
 * Created by kotori on 2017/4/5.
 * 侧栏列表
 */
public class SideMenuAdapter extends BaseAdapter{

    private List<String> mlist;
    private Context mContext;

    public SideMenuAdapter(Context context, List<String> list) {
        mContext = context;
        mlist = list;
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
        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_side_menu,parent,false);
        TextView tv = (TextView) convertView.findViewById(R.id.tv_item_side_menu);
        tv.setText(mlist.get(position));
        return convertView;
    }
}
