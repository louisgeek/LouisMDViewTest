package com.louisgeek.louismdviewtest;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by louisgeek on 2016/9/11.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final String TAG = "MyRecyclerViewAdapter";
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.content_list_item,parent,false);

        return new MyRecyclerViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyRecyclerViewViewHolder myRecyclerViewViewHolder= (MyRecyclerViewViewHolder) holder;
        myRecyclerViewViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: xxxx"+position);
            }
        });

        myRecyclerViewViewHolder.id_tv.setText("item"+position);

    }

    @Override
    public int getItemCount() {
        return 35;
    }
    
    
    class MyRecyclerViewViewHolder extends RecyclerView.ViewHolder{

        TextView id_tv;
        public MyRecyclerViewViewHolder(View itemView) {
            super(itemView);
            id_tv= (TextView) itemView.findViewById(R.id.id_tv);
        }
    }
}
