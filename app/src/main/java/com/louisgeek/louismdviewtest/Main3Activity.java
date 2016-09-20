package com.louisgeek.louismdviewtest;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {
    BottomSheetBehavior mBottomSheetBehavior;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

/**
 * 直接配置的NestedScrollView 在23.2.x以上滑不回来。。。暂时放弃
 */


        View id_nsv_bottom_sheet_behavior_container=findViewById(R.id.id_nsv_bottom_sheet_behavior_container);

        RecyclerView idrv = (RecyclerView) findViewById(R.id.id_rv);
        //idrv.setLayoutManager(new LinearLayoutManager(this));
         idrv.setLayoutManager(new GridLayoutManager(this,6));
        idrv.setAdapter(new MyRecyclerViewAdapter());

        mBottomSheetBehavior = BottomSheetBehavior.from(id_nsv_bottom_sheet_behavior_container);


        Button id_btn_show_bottom = (Button) findViewById(R.id.id_btn_show_bottom);
        id_btn_show_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                } else if (mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            }
        });


    }
}
