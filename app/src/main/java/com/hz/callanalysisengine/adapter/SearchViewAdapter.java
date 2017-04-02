package com.hz.callanalysisengine.adapter;

import android.content.Context;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hz.callanalysisengine.R;
import com.hz.callanalysisengine.bean.SearchItem;
import com.hz.callanalysisengine.holder.SearchViewHolder;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by kotori on 2017/4/2.
 * 装载搜索信息的adapter
 */
public class SearchViewAdapter extends BaseAdapter{

    private List<SearchItem> mList;
    private Context mContext;
    private LayoutInflater mInflater;

    public SearchViewAdapter(Context context, List<SearchItem> list) {
        mList = list;
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
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
        SearchViewHolder viewHolder = null;
        if(convertView == null) {
            convertView = mInflater.inflate(R.layout.item_search_view,parent,false);
            viewHolder = new SearchViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (SearchViewHolder) convertView.getTag();
        }
        viewHolder.iv_call_img.setImageResource(R.mipmap.ic_launcher);
        viewHolder.tv_call_name.setText(mList.get(position).getCallName());
        viewHolder.tv_call_singer.setText(mList.get(position).getSinger());
        viewHolder.tv_call_id.setText(mList.get(position).getCallID());
        return convertView;
    }
}
