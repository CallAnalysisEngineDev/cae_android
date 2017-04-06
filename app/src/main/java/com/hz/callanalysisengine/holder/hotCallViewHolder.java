package com.hz.callanalysisengine.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hz.callanalysisengine.R;
import com.hz.callanalysisengine.interfaces.IhotRVItemListener;

/**
 * Created by kotori on 2017/4/6.
 * 热门歌曲实例类
 */
public class HotCallViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public ImageView iv_hot_call_img;
    public TextView tv_hot_call_text;
    IhotRVItemListener mListener;

    public HotCallViewHolder(View itemView,IhotRVItemListener ihotRVItemListener) {
        super(itemView);
        iv_hot_call_img = (ImageView) itemView.findViewById(R.id.iv_call_view_img);
        tv_hot_call_text = (TextView) itemView.findViewById(R.id.tv_call_view_text);
        mListener = ihotRVItemListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(mListener!=null) {
            mListener.onItemOnClick(v,getPosition());
        }
    }
}
