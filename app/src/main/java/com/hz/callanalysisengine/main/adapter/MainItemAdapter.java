package com.hz.callanalysisengine.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hz.callanalysisengine.R;

import java.util.List;

/**
 * Created by kotori on 2017/4/6.
 * 首页item的适配器
 */
public class MainItemAdapter extends BaseAdapter{

    private Context mContext;
    private List<String> mDataList;
    private List<Integer> mItemList;

    public MainItemAdapter(Context context,List<String> datas,List<Integer> items) {
        mContext = context;
        mDataList = datas;
        mItemList = items;
    }

    @Override
    public int getCount() {
        return mDataList.size();
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
        ViewHolder holder = null;
        if(convertView==null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_main_item,parent,false);
            holder = new ViewHolder();
            holder.mTextview = (TextView) convertView.findViewById(R.id.tv_main_item);
            holder.mImageview = (ImageView)convertView.findViewById(R.id.iv_main_item);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mTextview.setText(mDataList.get(position));
        holder.mImageview.setImageResource(mItemList.get(position));
        return convertView;
    }

    // 定义viewHolder类
    class ViewHolder{
        TextView mTextview;
        ImageView mImageview;

    }
}
