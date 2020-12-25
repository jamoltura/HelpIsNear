package com.example.helpisnear.ui.map_of_adverse_events;

import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helpisnear.MainActivity;
import com.example.helpisnear.R;
import com.example.helpisnear.interfaces.MobileNavigation;
import com.example.helpisnear.model.HomeViewModel;

public class MapOfAdverseEventsFragment extends Fragment {

    private static final String TAG = "myLogs";

    private int LAUNCH_ACTIVITY= 1;

    public static MapOfAdverseEventsFragment newInstance() {
        return new MapOfAdverseEventsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map_of_adverse_events_fragment, container, false);



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // TODO: Use the ViewModel
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LAUNCH_ACTIVITY){
            if (resultCode == Activity.RESULT_OK){

                MobileNavigation navigation = ((MainActivity) getActivity()).getNavigation();

                int value = data.getIntExtra("result", -1);

                switch (value){
                    case 0 : navigation.stranger_home();
                        break;
                    case 1 : navigation.stranger_what_to_do();
                        break;
                    case 2 : navigation.stranger_first_aid();
                        break;
                    case 3 : navigation.stranger_map_of_adverse_events();
                        break;
                    case 4 : navigation.stranger_check_your_self();
                        break;
                    case 5 : navigation.stranger_encyclopedia();
                        break;
                    case 6 : navigation.stranger_information_and_settings();
                }
            }
        }
    }
}