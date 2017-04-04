package com.hz.callanalysisengine.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hz.callanalysisengine.R;

/**
 * Created by kotori on 2017/4/2.
 * 装载搜索消息的holder
 */
public class SearchViewHolder {

    public ImageView iv_call_img;
    public TextView tv_call_name;
    public TextView tv_call_singer;
    public TextView tv_call_id;


    public SearchViewHolder(View itemView) {
        iv_call_img = (ImageView) itemView.findViewById(R.id.iv_call_message_img);
        tv_call_name = (TextView) itemView.findViewById(R.id.tv_call_name);
        tv_call_singer = (TextView) itemView.findViewById(R.id.tv_call_singer);
//        tv_call_id = (TextView) itemView.findViewById(R.id.tv_call_id);
    }
}
