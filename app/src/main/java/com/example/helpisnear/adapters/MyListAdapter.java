package com.example.helpisnear.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helpisnear.R;
import com.example.helpisnear.classes.ElementList;

import java.util.ArrayList;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{

    private static final String TAG = "myLogs";
    private int resId;
    private LayoutInflater mInflater;
    private ArrayList<ElementList> list;

    public MyListAdapter(Context context, int resId, ArrayList<ElementList> list) {
        mInflater = LayoutInflater.from(context);
        this.resId = resId;
        this.list = list;
    }

    @NonNull
    @Override
    public MyListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = mInflater.inflate(resId, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.ViewHolder holder, int position) {
        holder.imageView.setBackgroundResource(list.get(position).getIdDrawable());
        holder.textView.setText(list.get(position).getIdString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_item_list);
            textView = itemView.findViewById(R.id.text_item_list);
        }
    }
}
