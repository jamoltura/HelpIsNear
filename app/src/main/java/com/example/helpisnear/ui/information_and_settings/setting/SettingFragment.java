package com.example.helpisnear.ui.information_and_settings.setting;

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
import com.example.helpisnear.interfaces.InitializationLanguage;
import com.example.helpisnear.interfaces.MobileNavigation;
import com.example.helpisnear.classes.RecyclerItemClickListener;
import com.example.helpisnear.model.HomeViewModel;

public class SettingFragment extends Fragment {

    private HomeViewModel mViewModel;

    private RecyclerView recyclerView;
    private MyListAdapter adapter;

    private int LAUNG_ACTIVITY= 1;
    private int SETCALLBTN_ACTIVITY= 2;

    public static SettingFragment newInstance() {
        return new SettingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.setting_fragment, container, false);

        MobileNavigation navigation = ((MainActivity) getActivity()).getNavigation();

        recyclerView = v.findViewById(R.id.recycler_setting);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener(){

            @Override
            public void onItemClick(View view, int position) {

                Intent intent;
                switch (position){
                    case 0 :
                        intent = new Intent(getContext(), InfoActivity.class);
                        intent.putExtra("type_info", "SettingsLang");
                        startActivityForResult(intent, LAUNG_ACTIVITY);
                        break;
                    case 1 :
                        intent = new Intent(getContext(), InfoActivity.class);
                        intent.putExtra("type_info", "SetCallBtn");
                        startActivityForResult(intent, SETCALLBTN_ACTIVITY);
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

        mViewModel = ViewModelProviders.of(getActivity()).get(HomeViewModel.class);

        adapter = new MyListAdapter(getContext(), R.layout.item_list_arrow, ListResource.getInstance().getSettingsLangResource());

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LAUNG_ACTIVITY){
            if (resultCode == Activity.RESULT_OK){

                InitializationLanguage language = ((MainActivity) getActivity()).getInitializationLanguage();
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
                        break;
                    case 7 : language.init_ru();
                        break;
                    case 8 : language.init_default();
                        break;
                    case 9 : language.init_uz();
                        break;
                    case 10 : language.init_en();
                }

                adapter = new MyListAdapter(getContext(), R.layout.item_list_arrow, ListResource.getInstance().getSettingsLangResource());

                recyclerView.setAdapter(adapter);
            }
        }else if (requestCode == SETCALLBTN_ACTIVITY){
            if (resultCode == Activity.RESULT_OK) {

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