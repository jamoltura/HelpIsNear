package com.example.helpisnear.ui.encyclopedia;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helpisnear.R;
import com.example.helpisnear.adapters.OtherAdapter;
import com.example.helpisnear.classes.ListResource;
import com.example.helpisnear.model.HomeViewModel;

public class EncyclopediaFragment extends Fragment {

    private static final String TAG = "myLogs";

    private RecyclerView recyclerView;
    private OtherAdapter adapter;

    public static EncyclopediaFragment newInstance() {
        return new EncyclopediaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.encyclopedia_fragment, container, false);

        recyclerView = v.findViewById(R.id.recycler_encyclopedia);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        HomeViewModel mViewModel = ViewModelProviders.of(getActivity()).get(HomeViewModel.class);

        adapter = new OtherAdapter(getContext(), ListResource.getInstance().getEncyclopediaResource());

        recyclerView.setAdapter(adapter);
    }

}