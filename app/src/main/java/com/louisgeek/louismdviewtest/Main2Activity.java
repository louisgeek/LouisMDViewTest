package com.louisgeek.louismdviewtest;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    BottomSheetBehavior  mBottomSheetBehavior;
    /**
     *   <string name="appbar_scrolling_view_behavior" translatable="false">
     *       android.support.design.widget.AppBarLayout$ScrollingViewBehavior
     *       </string>
     <string name="bottom_sheet_behavior" translatable="false">
     android.support.design.widget.BottomSheetBehavior
     </string>



     //Bottom Sheet 一共有五个状态回调：
     //STATE_COLLAPSED
     //折叠状态。可通过app:behavior_peekHeight来设置默认显示的高度。

     //STATE_SETTING
     //拖拽松开之后到达终点位置（collapsed or expanded）前的状态。

     //STATE_EXPANDED
     //完全展开的状态。

     //STATE_HIDDEN
     //隐藏状态。默认是false，可通过app:behavior_hideable属性设置。

     //STATE_DRAGGING
     //被拖拽状态


     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


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
        View id_ll_bottom_sheet_behavior_container=findViewById(R.id.id_ll_bottom_sheet_behavior_container);

        RecyclerView idrv = (RecyclerView) id_ll_bottom_sheet_behavior_container.findViewById(R.id.id_rv);
       idrv.setLayoutManager(new LinearLayoutManager(this));
        // idrv.setLayoutManager(new GridLayoutManager(this,6));
        idrv.setAdapter(new MyRecyclerViewAdapter());

        mBottomSheetBehavior = BottomSheetBehavior.from(id_ll_bottom_sheet_behavior_container);


    }
}
