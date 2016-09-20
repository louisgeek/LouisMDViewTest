package com.louisgeek.louismdviewtest;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

public class Main4Activity extends AppCompatActivity {

    BottomSheetBehavior<View> behavior;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        mContext=this;

        //////
        View id_bottom_sheet_container =  findViewById(R.id.id_bottom_sheet_container);
        behavior=  BottomSheetBehavior.from(id_bottom_sheet_container);



        AppCompatButton btnBottomSheetDialog = (AppCompatButton) findViewById(R.id.btnBottomSheetDialog);
        btnBottomSheetDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(mContext);

                View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_content, null);

                RecyclerView id_rv = (RecyclerView) view.findViewById(R.id.id_rv);
                id_rv.setLayoutManager(new LinearLayoutManager(mContext));
                id_rv.setAdapter(new MyRecyclerViewAdapter());
                //
                bottomSheetDialog.setContentView(view);
                bottomSheetDialog.show();
            }
        });


       // View bottomSheet = findViewById(R.id.bottom_sheet);
       // BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(id_bottom_sheet_container);
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);

        AppCompatButton btnBottomSheetDialogFragment = (AppCompatButton) findViewById(R.id.btnBottomSheetDialogFragment);
        btnBottomSheetDialogFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (new MyBottomSheetDialogFragment()).show(getSupportFragmentManager(), "xxx");
            }
        });




    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public class MyBottomSheetDialogFragment extends BottomSheetDialogFragment {


        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return super.onCreateDialog(savedInstanceState);
        }

        @Override
        public void setupDialog(Dialog dialog, int style) {
            super.setupDialog(dialog, style);

            View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_content, null);

            RecyclerView idrv = (RecyclerView) view.findViewById(R.id.id_rv);
            idrv.setLayoutManager(new GridLayoutManager(getActivity(),5));
            idrv.setAdapter(new MyRecyclerViewAdapter());

            dialog.setContentView(view);
        }
}
}
