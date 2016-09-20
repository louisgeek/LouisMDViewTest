package com.louisgeek.louismdviewtest;

import android.support.v7.widget.RecyclerView;

/**
 * Created by louisgeek on 2016/9/14.
 */
public abstract  class OnRecyclerViewVerticalScrollListener extends RecyclerView.OnScrollListener{
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        /**
         * 这个方法利用了View的一个方法。public boolean canScrollVertically (int direction)
         这个方法是判断View在竖直方向是否还能 向上，向下 滑动。

         根据上面的例子，应该可以看出。 -1 表示 向上， 1 表示向下。

         同理还有 public boolean canScrollHorizontally (int direction) 方法用来判断 水平方向的滑动。
         */
        if (!recyclerView.canScrollVertically(-1)) {
            onScrolledToTop();
        } else if (!recyclerView.canScrollVertically(1)) {
            onScrolledToBottom();
        } else if (dy < 0) {
            onScrolledUp();
        } else if (dy > 0) {
            onScrolledDown();
        }
    }


    public abstract  void onScrolledUp();

    public  abstract void onScrolledDown();

    public  abstract void onScrolledToTop();

    public  abstract void onScrolledToBottom();
}
