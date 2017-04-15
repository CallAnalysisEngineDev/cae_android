package com.hz.callanalysisengine.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

import java.lang.ref.WeakReference;

/**
 * Created by kotori on 2017/4/15.
 * 自定义自动滚动RecycleView
 */
public class AutoPollRecycleView extends RecyclerView {

    private static final long TIME_AUTO_POLL = 16;
    AutoPollTask autoPollTask;
    private boolean running;            //标示是否正在自动轮询
    private boolean canRun;             //标示是否可以自动轮询,可在不需要的是否置false

    public AutoPollRecycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        autoPollTask = new AutoPollTask(this);
    }

    static class AutoPollTask implements Runnable {
        private final WeakReference<AutoPollRecycleView> mReference;

        //使用弱引用持有外部类引用->防止内存泄漏
        public AutoPollTask(AutoPollRecycleView reference) {
            this.mReference = new WeakReference<AutoPollRecycleView>(reference);
        }

        @Override
        public void run() {
            AutoPollRecycleView recycleView = mReference.get();
            if (recycleView != null && recycleView.running && recycleView.canRun) {
                recycleView.scrollBy(2, 2);
                recycleView.postDelayed(recycleView.autoPollTask,recycleView.TIME_AUTO_POLL);
            }
        }
    }
    //开启:如果正在运行,先停止->再开启
    public void start() {
        if (running)
            stop();
        canRun = true;
        running = true;
        postDelayed(autoPollTask,TIME_AUTO_POLL);
    }
    public void stop(){
        running = false;
        removeCallbacks(autoPollTask);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:       // 当用户点击时
                if (running)
                    stop();
                break;
            case MotionEvent.ACTION_OUTSIDE:    // 当用户松开时
                if (canRun)
                    start();
                break;
        }
        return super.onTouchEvent(e);
    }
}