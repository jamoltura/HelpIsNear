package com.example.helpisnear.ui.first_aid;

import android.app.Activity;
import android.content.Intent;
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

import com.example.helpisnear.MainActivity;
import com.example.helpisnear.R;
import com.example.helpisnear.activites.InfoActivity;
import com.example.helpisnear.adapters.MyListAdapter;
import com.example.helpisnear.classes.ListResource;
import com.example.helpisnear.interfaces.MobileNavigation;
import com.example.helpisnear.classes.RecyclerItemClickListener;
import com.example.helpisnear.model.HomeViewModel;

public class FirstAidFragment extends Fragment {

    private static final String TAG = "myLogs";

    private int LAUNCH_ACTIVITY= 1;

    private RecyclerView recyclerView;
    private MyListAdapter adapter;

    public static FirstAidFragment newInstance() {
        return new FirstAidFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.first_aid_fragment, container, false);

        recyclerView = v.findViewById(R.id.recycler_first_aid);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getContext(), InfoActivity.class);
                intent.putExtra("type_info", "FirstAid");
                intent.putExtra("position", String.valueOf(position));
                startActivityForResult(intent, LAUNCH_ACTIVITY);
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

        adapter = new MyListAdapter(getContext(), R.layout.item_list_arrow, ListResource.getInstance().getFirstAidResource());

        recyclerView.setAdapter(adapter);
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

            }else if (resultCode == Activity.RESULT_CANCELED){

            }
        }
    }

}