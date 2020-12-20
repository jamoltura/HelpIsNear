package com.example.helpisnear.ui.home;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.helpisnear.MainActivity;
import com.example.helpisnear.R;
import com.example.helpisnear.adapters.HomeAdapter;
import com.example.helpisnear.classes.SliderAdapterExample;
import com.example.helpisnear.classes.SliderBuilder;
import com.example.helpisnear.classes.UnitMchsResource;
import com.example.helpisnear.classes.UnitResource;
import com.example.helpisnear.interfaces.MobileNavigation;
import com.example.helpisnear.interfaces.RecyclerItemClickListener;
import com.example.helpisnear.model.HomeViewModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private static final String TAG = "myLogs";

    private SearchView searchView;
    private RecyclerView recyclerView;
    private HomeAdapter adapter;


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment, container, false);

        MobileNavigation navigation = ((MainActivity) getActivity()).getNavigation();

        recyclerView = v.findViewById(R.id.recycler_home);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener(){

            @Override
            public void onItemClick(View view, int position) {

                switch (position){
                    case 0 : navigation.home_what_to_do();
                        break;
                    case 1 : navigation.home_first_aid();
                        break;
                    case 2 : navigation.home_map_of_adverse_events();
                        break;
                    case 3 : navigation.home_check_your_self();
                        break;
                    case 4 : navigation.home_encyclopedia();
                        break;
                    case 5 : navigation.home_information_and_settings();
                }
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        HomeViewModel mViewModel = ViewModelProviders.of(getActivity()).get(HomeViewModel.class);

        adapter = new HomeAdapter(getContext());

        recyclerView.setAdapter(adapter);
    }
}