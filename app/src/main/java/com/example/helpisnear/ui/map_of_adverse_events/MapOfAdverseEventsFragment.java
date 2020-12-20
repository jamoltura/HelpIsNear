package com.example.helpisnear.ui.map_of_adverse_events;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helpisnear.R;
import com.example.helpisnear.model.HomeViewModel;

public class MapOfAdverseEventsFragment extends Fragment {

    public static MapOfAdverseEventsFragment newInstance() {
        return new MapOfAdverseEventsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.map_of_adverse_events_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        HomeViewModel mViewModel = ViewModelProviders.of(getActivity()).get(HomeViewModel.class);
        // TODO: Use the ViewModel
    }

}