package com.example.helpisnear.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helpisnear.R;

import java.util.ArrayList;

public class OtherAdapter extends RecyclerView.Adapter<OtherAdapter.ViewHolder>{

    private static final String TAG = "myLogs";
    private LayoutInflater mInflater;
    private ArrayList<Integer> list;

    public OtherAdapter(Context context, ArrayList<Integer> list) {
        mInflater = LayoutInflater.from(context);
        this.list = list;
    }

    @NonNull
    @Override
    public OtherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = mInflater.inflate(R.layout.item_list_arrow, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OtherAdapter.ViewHolder holder, int position) {

        holder.imageView.setBackgroundResource(R.drawable.ic_element);
        holder.textView.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_item_list_arrow);
            textView = itemView.findViewById(R.id.text_item_list_arrow);
        }
    }
}
