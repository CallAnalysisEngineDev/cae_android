package com.hz.callanalysisengine.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hz.callanalysisengine.R;
import com.hz.callanalysisengine.bean.MainDataBean;
import com.hz.callanalysisengine.constant.Constant;
import com.hz.callanalysisengine.holder.HotCallViewHolder;
import com.hz.callanalysisengine.interfaces.IhotRVItemListener;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by kotori on 2017/4/6.
 * 热门歌曲适配器
 */
public class HotCallViewAdapter extends RecyclerView.Adapter<HotCallViewHolder>{

    private Context mContext;
    private List<MainDataBean.RedBean> mHotList;
    private IhotRVItemListener mListener;

    public HotCallViewAdapter(Context context, List<MainDataBean.RedBean> list) {
        mContext = context;
        mHotList = list;
    }

    @Override
    public HotCallViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_call_view,parent,false);
        HotCallViewHolder viewHolder = new HotCallViewHolder(view,mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HotCallViewHolder holder, int position) {
        Picasso.with(mContext)
                .load(mHotList.get(position%mHotList.size()).getSongCover())
                .into(holder.iv_hot_call_img);
        holder.tv_hot_call_text.setText(mHotList.get(position%mHotList.size()).getSongName());
    }


    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    public void setItemOnClickListener(IhotRVItemListener listener){
        mListener=listener;
    }


}
