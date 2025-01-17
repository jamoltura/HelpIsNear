package com.example.helpisnear.classes;

import android.content.res.Resources;
import android.graphics.Color;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class SliderBuilder {

    private ArrayList<SliderItem> list;
    private SliderView sliderView;
    private SliderAdapterExample adapter;

    public SliderBuilder(SliderView sliderView, SliderAdapterExample adapter) {
        this.sliderView = sliderView;
        this.adapter = adapter;

    }

    public void setResource(Resources res, ArrayList<UnitResource> resource){
        list = new ArrayList<>();
        int count = resource.size();

        if (count > 0){
            for (int i = 0; i < count; i++){
                SliderItem sliderItem = new SliderItem(res, resource.get(i).getLocalAdress(), i);
                list.add(sliderItem);
            }
        }
    }


    public void build(){

        adapter.renewItems(list);

        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();
    }
}
