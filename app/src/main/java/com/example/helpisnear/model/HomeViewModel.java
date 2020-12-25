package com.example.helpisnear.model;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.helpisnear.classes.LocaleHelper;
import com.example.helpisnear.classes.MchsResource;
import com.example.helpisnear.classes.MyDownload;
import com.example.helpisnear.classes.UnitMchsResource;
import com.example.helpisnear.classes.test.Test;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel{

    private static final String TAG = "myLogs";

    private MutableLiveData<ArrayList<UnitMchsResource>> dataMchs_WhatToDo;
    private MutableLiveData<ArrayList<UnitMchsResource>> dataMchs_FirstAid;
    private MutableLiveData<ArrayList<UnitMchsResource>> dataMchs_Encyclopedia;
    private MutableLiveData<ArrayList<UnitMchsResource>> dataMchs_InformationAndSettings;

    private MutableLiveData<ArrayList<Test.TestList>> dataTest;

    public HomeViewModel() {
        super();
    }

    public void init(Context context){
        MchsResource resource = new MchsResource(context);

        dataMchs_WhatToDo = new MutableLiveData<>();
        dataMchs_WhatToDo.postValue(resource.getMchsResources_WhatToDo());

        dataMchs_FirstAid = new MutableLiveData<>();
        dataMchs_FirstAid.postValue(resource.getMchsResources_FirstAid());

        dataMchs_Encyclopedia = new MutableLiveData<>();
        dataMchs_Encyclopedia.postValue(resource.getMchsResources_Encyclopedia());

        dataMchs_InformationAndSettings = new MutableLiveData<>();
        dataMchs_InformationAndSettings.postValue(resource.getMchsResources_InformationAndSettings());

        Test test = new Test(context.getResources());

        dataTest = new MutableLiveData<>();
        dataTest.postValue(test.getTestLists());
    }

    public void update(Context context){
        MchsResource resource = new MchsResource(context);
        dataMchs_WhatToDo.postValue(resource.getMchsResources_WhatToDo());
        dataMchs_FirstAid.postValue(resource.getMchsResources_FirstAid());
        dataMchs_Encyclopedia.postValue(resource.getMchsResources_Encyclopedia());
        dataMchs_InformationAndSettings.postValue(resource.getMchsResources_InformationAndSettings());
    }

    public MutableLiveData<ArrayList<UnitMchsResource>> getDataMchs_WhatToDo() {
        return dataMchs_WhatToDo;
    }

    public MutableLiveData<ArrayList<UnitMchsResource>> getDataMchs_FirstAid() {
        return dataMchs_FirstAid;
    }

    public MutableLiveData<ArrayList<UnitMchsResource>> getDataMchs_Encyclopedia() {
        return dataMchs_Encyclopedia;
    }

    public MutableLiveData<ArrayList<UnitMchsResource>> getDataMchs_InformationAndSettings() {
        return dataMchs_InformationAndSettings;
    }

    public MutableLiveData<ArrayList<Test.TestList>> getDataTest() {
        return dataTest;
    }
}
