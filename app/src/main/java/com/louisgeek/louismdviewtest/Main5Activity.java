package com.louisgeek.louismdviewtest;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class Main5Activity extends AppCompatActivity {
    BottomSheetBehavior behavior;
    private static final String TAG = "Main5Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        //XML  android:theme="@style/XXX" 或   getSupportActionBar().hide();
        getSupportActionBar().hide();

        //////
        View id_ll_bottom_sheet_behavior_container =  findViewById(R.id.id_ll_bottom_sheet_behavior_container);
        behavior=  BottomSheetBehavior.from(id_ll_bottom_sheet_behavior_container);

        RecyclerView idrv = (RecyclerView) findViewById(R.id.id_rv);
        idrv.setLayoutManager(new LinearLayoutManager(this));
        idrv.setAdapter(new MyRecyclerViewAdapter());

        idrv.addOnScrollListener(new OnRecyclerViewVerticalScrollListener() {
            @Override
            public void onScrolledUp() {
                Log.i(TAG, "onScrolledUp:");
                if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }

            @Override
            public void onScrolledDown() {
                Log.i(TAG, "onScrolledDown:");
                if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }

            @Override
            public void onScrolledToTop() {
                Log.i(TAG, "onScrolledToTop: =====");
                if (behavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }

            }

            @Override
            public void onScrolledToBottom() {
                Log.i(TAG, "onScrolledToBottom: =====");
                /*if (behavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }*/
            }
        });


    }
}
