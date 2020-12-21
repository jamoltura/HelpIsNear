package com.example.helpisnear.classes;

import com.example.helpisnear.R;

import java.util.ArrayList;

public class ListResource {

   private static ListResource listResource;

    private ArrayList<ElementList> homeResource;
    private ArrayList<ElementList> whatToDoResource;
    private ArrayList<ElementList> firstAidResource;
    private ArrayList<ElementList> mapOfAdverseEventsResource;
    private ArrayList<ElementList> checkYourSelfResource;
    private ArrayList<ElementList> encyclopediaResource;
    private ArrayList<ElementList> informationAndSettingsResource;
    private ArrayList<ElementList> SettingsLangResource;


    public static ListResource getInstance(){
        if (listResource == null) {
            listResource = new ListResource();
        }
        return listResource;
    }

    public ListResource() {
        homeResource = getHome();
        whatToDoResource = getWhatToDo();
        firstAidResource = getFirstAid();
        mapOfAdverseEventsResource = getMapOfAdverseEvents();
        checkYourSelfResource = getCheckYourSelf();
        encyclopediaResource = getEncyclopedia();
        informationAndSettingsResource = getInformationAndSettings();
        SettingsLangResource = getSettingsLang();

    }

    public ArrayList<ElementList> getHomeResource() {
        return homeResource;
    }

    public ArrayList<ElementList> getWhatToDoResource() {
        return whatToDoResource;
    }

    public ArrayList<ElementList> getFirstAidResource() {
        return firstAidResource;
    }

    public ArrayList<ElementList> getMapOfAdverseEventsResource() {
        return mapOfAdverseEventsResource;
    }

    public ArrayList<ElementList> getCheckYourSelfResource() {
        return checkYourSelfResource;
    }

    public ArrayList<ElementList> getEncyclopediaResource() {
        return encyclopediaResource;
    }

    public ArrayList<ElementList> getInformationAndSettingsResource() {
        return informationAndSettingsResource;
    }

    public ArrayList<ElementList> getSettingsLangResource() {
        return SettingsLangResource;
    }

    private ArrayList<ElementList> getHome(){
        ArrayList<ElementList> list = new ArrayList<>();

        list.add(new ElementList(R.drawable.ic_element, R.string.menu_what_to_do));
        list.add(new ElementList(R.drawable.ic_element, R.string.menu_first_aid));
        list.add(new ElementList(R.drawable.ic_element, R.string.menu_map_of_adverse_events));
        list.add(new ElementList(R.drawable.ic_element, R.string.menu_check_yourself));
        list.add(new ElementList(R.drawable.ic_element, R.string.menu_encyclopedia));
        list.add(new ElementList(R.drawable.ic_element, R.string.menu_information_and_settings));

        return list;
    }

    private ArrayList<ElementList> getWhatToDo(){
        ArrayList<ElementList> list = new ArrayList<>();

        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_1));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_2));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_3));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_4));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_5));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_6));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_7));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_8));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_9));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_10));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_11));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_12));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_13));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_14));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_15));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_16));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_17));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_18));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_19));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_20));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_21));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_22));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_23));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_24));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_25));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_26));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_27));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_28));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_29));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_30));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_31));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_33));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_34));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_35));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_36));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_37));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_38));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_39));
        list.add(new ElementList(R.drawable.ic_element, R.string.what_to_do_element_40));

        return list;
    }

    private ArrayList<ElementList> getFirstAid() {
        ArrayList<ElementList> list = new ArrayList<>();

        list.add(new ElementList(R.drawable.ic_element, R.string.first_aid_element_1));
        list.add(new ElementList(R.drawable.ic_element, R.string.first_aid_element_2));
        list.add(new ElementList(R.drawable.ic_element, R.string.first_aid_element_3));
        list.add(new ElementList(R.drawable.ic_element, R.string.first_aid_element_4));
        list.add(new ElementList(R.drawable.ic_element, R.string.first_aid_element_5));
        list.add(new ElementList(R.drawable.ic_element, R.string.first_aid_element_6));
        list.add(new ElementList(R.drawable.ic_element, R.string.first_aid_element_7));
        list.add(new ElementList(R.drawable.ic_element, R.string.first_aid_element_8));
        list.add(new ElementList(R.drawable.ic_element, R.string.first_aid_element_9));
        list.add(new ElementList(R.drawable.ic_element, R.string.first_aid_element_10));
        list.add(new ElementList(R.drawable.ic_element, R.string.first_aid_element_11));
        list.add(new ElementList(R.drawable.ic_element, R.string.first_aid_element_12));
        list.add(new ElementList(R.drawable.ic_element, R.string.first_aid_element_13));
        list.add(new ElementList(R.drawable.ic_element, R.string.first_aid_element_14));

        return list;
    }

    private ArrayList<ElementList> getMapOfAdverseEvents() {
        ArrayList<ElementList> list = new ArrayList<>();


        return list;
    }

    private ArrayList<ElementList> getCheckYourSelf() {
        ArrayList<ElementList> list = new ArrayList<>();

        list.add(new ElementList(R.drawable.ic_element, R.string.check_your_self_element_1));
        list.add(new ElementList(R.drawable.ic_element, R.string.check_your_self_element_2));
        list.add(new ElementList(R.drawable.ic_element, R.string.check_your_self_element_3));
        list.add(new ElementList(R.drawable.ic_element, R.string.check_your_self_element_4));
        list.add(new ElementList(R.drawable.ic_element, R.string.check_your_self_element_5));
        list.add(new ElementList(R.drawable.ic_element, R.string.check_your_self_element_6));
        list.add(new ElementList(R.drawable.ic_element, R.string.check_your_self_element_7));
        list.add(new ElementList(R.drawable.ic_element, R.string.check_your_self_element_8));
        list.add(new ElementList(R.drawable.ic_element, R.string.check_your_self_element_9));
        list.add(new ElementList(R.drawable.ic_element, R.string.check_your_self_element_10));
        list.add(new ElementList(R.drawable.ic_element, R.string.check_your_self_element_11));
        list.add(new ElementList(R.drawable.ic_element, R.string.check_your_self_element_12));
        list.add(new ElementList(R.drawable.ic_element, R.string.check_your_self_element_13));
        list.add(new ElementList(R.drawable.ic_element, R.string.check_your_self_element_14));
        list.add(new ElementList(R.drawable.ic_element, R.string.check_your_self_element_15));
        list.add(new ElementList(R.drawable.ic_element, R.string.check_your_self_element_16));
        list.add(new ElementList(R.drawable.ic_element, R.string.check_your_self_element_17));
        list.add(new ElementList(R.drawable.ic_element, R.string.check_your_self_element_18));
        list.add(new ElementList(R.drawable.ic_element, R.string.check_your_self_element_19));
        list.add(new ElementList(R.drawable.ic_element, R.string.check_your_self_element_20));

        return list;
    }

    private ArrayList<ElementList> getEncyclopedia() {
        ArrayList<ElementList> list = new ArrayList<>();

        list.add(new ElementList(R.drawable.ic_element, R.string.encyclopedia_element_1));
        list.add(new ElementList(R.drawable.ic_element, R.string.encyclopedia_element_2));
        list.add(new ElementList(R.drawable.ic_element, R.string.encyclopedia_element_3));
        list.add(new ElementList(R.drawable.ic_element, R.string.encyclopedia_element_4));
        list.add(new ElementList(R.drawable.ic_element, R.string.encyclopedia_element_5));
        list.add(new ElementList(R.drawable.ic_element, R.string.encyclopedia_element_6));
        list.add(new ElementList(R.drawable.ic_element, R.string.encyclopedia_element_7));
        list.add(new ElementList(R.drawable.ic_element, R.string.encyclopedia_element_8));
        list.add(new ElementList(R.drawable.ic_element, R.string.encyclopedia_element_9));
        list.add(new ElementList(R.drawable.ic_element, R.string.encyclopedia_element_10));
        list.add(new ElementList(R.drawable.ic_element, R.string.encyclopedia_element_11));
        list.add(new ElementList(R.drawable.ic_element, R.string.encyclopedia_element_12));
        list.add(new ElementList(R.drawable.ic_element, R.string.encyclopedia_element_13));
        list.add(new ElementList(R.drawable.ic_element, R.string.encyclopedia_element_14));
        list.add(new ElementList(R.drawable.ic_element, R.string.encyclopedia_element_15));
        list.add(new ElementList(R.drawable.ic_element, R.string.encyclopedia_element_16));
        list.add(new ElementList(R.drawable.ic_element, R.string.encyclopedia_element_17));
        list.add(new ElementList(R.drawable.ic_element, R.string.encyclopedia_element_18));
        list.add(new ElementList(R.drawable.ic_element, R.string.encyclopedia_element_19));
        list.add(new ElementList(R.drawable.ic_element, R.string.encyclopedia_element_20));
        list.add(new ElementList(R.drawable.ic_element, R.string.encyclopedia_element_21));
        list.add(new ElementList(R.drawable.ic_element, R.string.encyclopedia_element_22));
        list.add(new ElementList(R.drawable.ic_element, R.string.encyclopedia_element_23));

        return list;
    }

    private ArrayList<ElementList> getInformationAndSettings() {
        ArrayList<ElementList> list = new ArrayList<>();

        list.add(new ElementList(R.drawable.ic_element, R.string.information_and_settings_element_1));
        list.add(new ElementList(R.drawable.ic_element, R.string.information_and_settings_element_2));
        list.add(new ElementList(R.drawable.ic_element, R.string.information_and_settings_element_3));
        list.add(new ElementList(R.drawable.ic_element, R.string.information_and_settings_element_4));

        return list;
    }

    private ArrayList<ElementList> getSettingsLang(){
        ArrayList<ElementList> list = new ArrayList<>();

        list.add(new ElementList(R.drawable.ic_element, R.string.settings_element_1));
        list.add(new ElementList(R.drawable.ic_element, R.string.settings_element_2));

        return list;
    }


}
