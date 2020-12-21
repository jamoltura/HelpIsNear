package com.example.helpisnear.ui.home;

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
import android.widget.SearchView;

import com.example.helpisnear.MainActivity;
import com.example.helpisnear.R;
import com.example.helpisnear.adapters.MyListAdapter;
import com.example.helpisnear.classes.ListResource;
import com.example.helpisnear.interfaces.MobileNavigation;
import com.example.helpisnear.classes.RecyclerItemClickListener;
import com.example.helpisnear.model.HomeViewModel;

public class HomeFragment extends Fragment {

    private static final String TAG = "myLogs";

    private SearchView searchView;
    private RecyclerView recyclerView;
    private MyListAdapter adapter;


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

        adapter = new MyListAdapter(getContext(), R.layout.item_list, ListResource.getInstance().getHomeResource());

        recyclerView.setAdapter(adapter);
    }
}