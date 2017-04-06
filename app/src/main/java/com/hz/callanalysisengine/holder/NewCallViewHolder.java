package com.hz.callanalysisengine.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hz.callanalysisengine.R;

/**
 * Created by kotori on 2017/4/6.
 * 热门歌曲实例类
 */
public class NewCallViewHolder {
    public ImageView iv_hot_call_img;
    public TextView tv_hot_call_text;


    public NewCallViewHolder(View itemView) {
        iv_hot_call_img = (ImageView) itemView.findViewById(R.id.iv_call_view_img);
        tv_hot_call_text = (TextView) itemView.findViewById(R.id.tv_call_view_text);
    }
}
