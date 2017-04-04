package com.hz.callanalysisengine.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hz.callanalysisengine.R;

/**
 * Created by kotori on 2017/4/3.
 * call表信息的页面
 */
public class CallMainFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_call_main,container,false);
        return view;
    }
}
