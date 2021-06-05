package com.example.thegame.test;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class MyScrollView extends ScrollView {
    private int mLastY = 0;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        boolean intercepted = false;
//        int y = (int) ev.getY();
//        switch (ev.getActionMasked()) {
//            case MotionEvent.ACTION_DOWN:
//                intercepted = false;
//                //调用ScrollView的onInterceptTouchEvent()初始化mActivePointerId
//                super.onInterceptTouchEvent(ev);
//                break;
//            case MotionEvent.ACTION_MOVE:
//                int detY = y - mLastY;
//                //这里要找到子ScrollView
//                View contentView = findViewById(R.id.TA_listview);
//                if (contentView == null) {
//                    return true;
//                }
//                //判断子ScrollView是否滑动到顶部或者顶部
//                boolean isChildScrolledTop = detY > 0 && !contentView.canScrollVertically(-1);
//                boolean isChildScrolledBottom = detY < 0 && !contentView.canScrollVertically(1);
//                if (isChildScrolledTop || isChildScrolledBottom) {
//                    intercepted = true;
//                } else {
//                    intercepted = false;
//                }
//                break;
//            case MotionEvent.ACTION_UP:
//                intercepted = false;
//                break;
//        }
//        mLastY = y;
//        return intercepted;
//    }
}
