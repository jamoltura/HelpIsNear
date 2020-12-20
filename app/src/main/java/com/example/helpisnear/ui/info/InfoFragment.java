package com.example.helpisnear.ui.info;

import androidx.lifecycle.Observer;
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
import com.example.helpisnear.classes.SliderAdapterExample;
import com.example.helpisnear.classes.SliderBuilder;
import com.example.helpisnear.classes.UnitMchsResource;
import com.example.helpisnear.classes.UnitResource;
import com.example.helpisnear.model.HomeViewModel;
import com.github.barteksc.pdfviewer.PDFView;
import com.smarteist.autoimageslider.SliderView;

import java.io.File;
import java.util.ArrayList;

public class InfoFragment extends Fragment {

    private SliderView sliderView;
    private SliderBuilder sliderBuilder;
    private PDFView pdfView;
    private int index;

    public static InfoFragment newInstance() {
        return new InfoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.info_fragment, container, false);

        sliderView = v.findViewById(R.id.imageSlider);
        pdfView = (PDFView) v.findViewById(R.id.pdfView);

        String position = getActivity().getIntent().getStringExtra("position");

        setIndex(Integer.parseInt(position));

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        HomeViewModel mViewModel = ViewModelProviders.of(getActivity()).get(HomeViewModel.class);

        mViewModel.getDataMchs_WhatToDo().observe(getViewLifecycleOwner(), new Observer<ArrayList<UnitMchsResource>>() {
            @Override
            public void onChanged(ArrayList<UnitMchsResource> unitMchsResources) {
                UnitMchsResource resource = unitMchsResources.get(getIndex());
                ArrayList<UnitResource> list = resource.getPngFiles();



                SliderAdapterExample adapter = new SliderAdapterExample();
                sliderBuilder = new SliderBuilder(sliderView, adapter);
                sliderBuilder.setResource(getResources(), list);
                sliderBuilder.build();

                if (resource.getPdfFile().isExists()){
                    File file = new File(resource.getPdfFile().getLocalAdress());
                    pdfView.fromFile(file).load();
                }else {
                    pdfView.fromStream(getResources().openRawResource(R.raw.default_pdf)).load();
                }
            }
        });
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}