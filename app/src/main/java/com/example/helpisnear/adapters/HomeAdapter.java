package com.example.helpisnear.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helpisnear.R;
import com.example.helpisnear.interfaces.MobileNavigation;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{

    private static final String TAG = "myLogs";
    private LayoutInflater mInflater;

    public HomeAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = mInflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
        switch (position){
            case 0:
                holder.imageView.setBackgroundResource(R.drawable.ic_element);
                holder.textView.setText(R.string.menu_what_to_do);
                break;
            case 1:
                holder.imageView.setBackgroundResource(R.drawable.ic_element);
                holder.textView.setText(R.string.menu_first_aid);
                break;
            case 2:
                holder.imageView.setBackgroundResource(R.drawable.ic_element);
                holder.textView.setText(R.string.menu_map_of_adverse_events);
                break;
            case 3:
                holder.imageView.setBackgroundResource(R.drawable.ic_element);
                holder.textView.setText(R.string.menu_check_yourself);
                break;
            case 4:
                holder.imageView.setBackgroundResource(R.drawable.ic_element);
                holder.textView.setText(R.string.menu_encyclopedia);
                break;
            case 5:
                holder.imageView.setBackgroundResource(R.drawable.ic_element);
                holder.textView.setText(R.string.menu_information_and_settings);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 6;
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
