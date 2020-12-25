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
import com.example.helpisnear.classes.test.Test;

public class TestListAdapter extends RecyclerView.Adapter<TestListAdapter.ViewHolder>{

    private Test.TestList testList;
    private int resId;
    private LayoutInflater mInflater;

    public TestListAdapter(Context context, int resId, Test.TestList testList) {
        mInflater = LayoutInflater.from(context);
        this.resId = resId;
        this.testList = testList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = mInflater.inflate(resId, parent, false);
        return new TestListAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(testList.getOnlyTests().get(position).getQuestion());
    }

    @Override
    public int getItemCount() {
        return testList.getOnlyTests().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_item_list);
        }
    }
}
