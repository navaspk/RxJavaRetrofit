package com.example.navaspk.nypopular.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class CustomRecyclerView extends RecyclerView {
    private final int mTouchSlop;
    private float mPrevX;
    // Indicate if we've already declined the move event
    private boolean mDeclined;
    private boolean mTouchInWebView = false;

    public CustomRecyclerView(Context context) {
        super(context);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public CustomRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public CustomRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        if(!mTouchInWebView && e.getAction() == MotionEvent.ACTION_DOWN) {
            View view = findChildViewUnder(e.getX(), e.getY());
            if (view != null) //touch is on the banner view
                mTouchInWebView = true;
            else {
                mTouchInWebView = false;
            }
        }

        if(mTouchInWebView) {
            switch (e.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mPrevX = MotionEvent.obtain(e).getX();
                    mDeclined = false; // New action
                    break;

                case MotionEvent.ACTION_MOVE:
                    final float eventX = e.getX();
                    float xDiff = Math.abs(eventX - mPrevX);
                    if (mDeclined || xDiff > mTouchSlop) {
                        mDeclined = true; // Memorize
                        return false;
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    mTouchInWebView = false;
                    break;
            }
        }
        return super.onInterceptTouchEvent(e);
    }
}
