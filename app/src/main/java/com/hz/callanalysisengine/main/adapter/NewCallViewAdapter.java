package com.hz.callanalysisengine.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hz.callanalysisengine.R;
import com.hz.callanalysisengine.bean.MainDataBean;
import com.hz.callanalysisengine.holder.NewCallViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by kotori on 2017/4/6.
 * 最近更新适配器
 */
public class NewCallViewAdapter extends BaseAdapter{

    private Context mContext;
    private List<MainDataBean.NewestBean> mNewList;

    public NewCallViewAdapter(Context context, List<MainDataBean.NewestBean> list) {
        mContext = context;
        mNewList = list;
    }

    @Override
    public int getCount() {
        return mNewList.size();
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
        NewCallViewHolder holder = null;
        if(convertView==null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_call_view,parent,false);
            holder = new NewCallViewHolder(convertView);
            convertView.setTag(holder);
        }
        else {
            holder = (NewCallViewHolder) convertView.getTag();
        }
        Picasso.with(mContext)
                .load(mNewList.get(position).getSongCover())
                .into(holder.iv_hot_call_img);
        holder.tv_hot_call_text.setText(mNewList.get(position).getSongName());
        return convertView;
    }
}
