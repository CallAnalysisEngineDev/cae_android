package com.hz.callanalysisengine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hz.callanalysisengine.constant.Constant;
import com.hz.callanalysisengine.R;
import com.hz.callanalysisengine.bean.SearchItemBean;
import com.hz.callanalysisengine.holder.SearchViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by kotori on 2017/4/2.
 * 装载搜索信息的adapter
 */
public class SearchViewAdapter extends BaseAdapter {

    private List<SearchItemBean.ResultListBean> mList;
    private Context mContext;
    private LayoutInflater mInflater;
    private boolean mTrue;

    public SearchViewAdapter(Context context, List<SearchItemBean.ResultListBean> list) {
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
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_search_view, parent, false);
            viewHolder = new SearchViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (SearchViewHolder) convertView.getTag();
        }

        Picasso.with(mContext)
                .load(Constant.IMG_URL + mList.get(position).getSongCover())
                .into(viewHolder.iv_call_img);
        viewHolder.tv_call_name.setText(mList.get(position).getSongName());
        viewHolder.tv_call_singer.setText(mList.get(position).getSongOwner());
        return convertView;
    }


}

