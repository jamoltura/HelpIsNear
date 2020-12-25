package com.example.helpisnear.ui_info.info;

import androidx.lifecycle.Observer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.helpisnear.R;
import com.example.helpisnear.classes.SliderAdapterExample;
import com.example.helpisnear.classes.SliderBuilder;
import com.example.helpisnear.classes.UnitMchsResource;
import com.example.helpisnear.classes.UnitResource;
import com.example.helpisnear.enums.TypeResourse;
import com.example.helpisnear.model.HomeViewModel;
import com.github.barteksc.pdfviewer.PDFView;
import com.smarteist.autoimageslider.SliderView;

import java.io.File;
import java.util.ArrayList;

public class InfoFragment extends Fragment{

    private RelativeLayout rl;
    private SliderView sliderView;
    private SliderBuilder sliderBuilder;
    private PDFView pdfView;
    private int index;
    private HomeViewModel mViewModel;

    public static InfoFragment newInstance() {
        return new InfoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.info_fragment, container, false);

        sliderView = v.findViewById(R.id.imageSlider);
        rl = v.findViewById(R.id.rl);
        pdfView = (PDFView) v.findViewById(R.id.pdfView);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(getActivity()).get(HomeViewModel.class);

        String action = this.getArguments().getString("type_info");
        String position = this.getArguments().getString("position");

        setIndex(Integer.parseInt(position));

        switch (action){
            case "WhatToDo": init_WhatToDo();
                break;
            case "FirstAid": init_FirstAid();
                break;
            case "Encyclopedia" : init_Encyclopedia();
                break;
            case "InfAndSettings" : init_InformationAndSettingsFragment();
        }
    }

    private void init_WhatToDo(){

        mViewModel.getDataMchs_WhatToDo().observe(getViewLifecycleOwner(), new Observer<ArrayList<UnitMchsResource>>() {
            @Override
            public void onChanged(ArrayList<UnitMchsResource> unitMchsResources) {
                _onchange(unitMchsResources);
            }
        });
    }

    private void init_FirstAid(){

        mViewModel.getDataMchs_FirstAid().observe(getViewLifecycleOwner(), new Observer<ArrayList<UnitMchsResource>>() {
            @Override
            public void onChanged(ArrayList<UnitMchsResource> unitMchsResources) {
                _onchange(unitMchsResources);
            }
        });
    }

    private void init_Encyclopedia(){

        mViewModel.getDataMchs_Encyclopedia().observe(getViewLifecycleOwner(), new Observer<ArrayList<UnitMchsResource>>() {
            @Override
            public void onChanged(ArrayList<UnitMchsResource> unitMchsResources) {
                _onchange(unitMchsResources);
            }
        });
    }

    private void init_InformationAndSettingsFragment(){

        mViewModel.getDataMchs_InformationAndSettings().observe(getViewLifecycleOwner(), new Observer<ArrayList<UnitMchsResource>>() {
            @Override
            public void onChanged(ArrayList<UnitMchsResource> unitMchsResources) {
                _onchange(unitMchsResources);
            }
        });
    }

    private void _onchange(ArrayList<UnitMchsResource> unitMchsResources){
        UnitMchsResource resource = unitMchsResources.get(getIndex());
        ArrayList<UnitResource> list = resource.getPngFiles();

        if (resource.getTypeResourse() == TypeResourse.ONLY_PDF){
            rl.setVisibility(View.GONE);
        }else {
            SliderAdapterExample adapter = new SliderAdapterExample();
            sliderBuilder = new SliderBuilder(sliderView, adapter);
            sliderBuilder.setResource(getResources(), list);
            sliderBuilder.build();
        }
        if (resource.getPdfFile().isExists()){
            File file = new File(resource.getPdfFile().getLocalAdress());
            pdfView.fromFile(file).load();
        }else {
            pdfView.fromStream(getResources().openRawResource(R.raw.default_pdf)).load();
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}