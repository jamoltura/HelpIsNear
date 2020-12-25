package com.example.helpisnear.ui_info.window_test;

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

public class WindowTestFragment extends Fragment {

    private HomeViewModel mViewModel;

    public static WindowTestFragment newInstance() {
        return new WindowTestFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.window_test_fragment, container, false);



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        // TODO: Use the ViewModel
    }

}