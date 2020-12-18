package com.example.helpisnear.ui.information_and_settings;

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

public class InformationAndSettingsFragment extends Fragment {

    private static final String TAG = "myLogs";

    private HomeViewModel mViewModel;

    private RecyclerView recyclerView;
    private OtherAdapter adapter;

    public static InformationAndSettingsFragment newInstance() {
        return new InformationAndSettingsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.information_and_settings_fragment, container, false);

        recyclerView = v.findViewById(R.id.recycler_information_and_setting);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        adapter = new OtherAdapter(getContext(), ListResource.getInstance().getInformationAndSettingsResource());

        recyclerView.setAdapter(adapter);
    }

}