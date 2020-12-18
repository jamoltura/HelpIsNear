package com.example.helpisnear.ui.check_yourself;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helpisnear.R;
import com.example.helpisnear.adapters.OtherAdapter;
import com.example.helpisnear.classes.ListResource;
import com.example.helpisnear.model.HomeViewModel;

public class CheckYourSelfFragment extends Fragment {

    private static final String TAG = "myLogs";

    private HomeViewModel mViewModel;

    private RecyclerView recyclerView;
    private OtherAdapter adapter;

    public static CheckYourSelfFragment newInstance() {
        return new CheckYourSelfFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.check_your_self_fragment, container, false);

        recyclerView = v.findViewById(R.id.recycler_check_your_self);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        adapter = new OtherAdapter(getContext(), ListResource.getInstance().getCheckYourSelfResource());

        recyclerView.setAdapter(adapter);
    }

}