package com.example.helpisnear.classes;

import com.example.helpisnear.R;

import java.util.ArrayList;

public class ListResource {

   private static ListResource listResource;

    private ArrayList<Integer> whatToDoResource;
    private ArrayList<Integer> firstAidResource;
    private ArrayList<Integer> mapOfAdverseEventsResource;
    private ArrayList<Integer> checkYourSelfResource;
    private ArrayList<Integer> encyclopediaResource;
    private ArrayList<Integer> informationAndSettingsResource;


    public static ListResource getInstance(){
        if (listResource != null){
            return listResource;
        }else {
            listResource = new ListResource();
            return listResource;
        }
    }


    public ListResource() {
        whatToDoResource = getWhatToDo();
        firstAidResource = getFirstAid();
        mapOfAdverseEventsResource = getMapOfAdverseEvents();
        checkYourSelfResource = getCheckYourSelf();
        encyclopediaResource = getEncyclopedia();
        informationAndSettingsResource = getInformationAndSettings();
    }

    public ArrayList<Integer> getWhatToDoResource() {
        return whatToDoResource;
    }

    public ArrayList<Integer> getFirstAidResource() {
        return firstAidResource;
    }

    public ArrayList<Integer> getMapOfAdverseEventsResource() {
        return mapOfAdverseEventsResource;
    }

    public ArrayList<Integer> getCheckYourSelfResource() {
        return checkYourSelfResource;
    }

    public ArrayList<Integer> getEncyclopediaResource() {
        return encyclopediaResource;
    }

    public ArrayList<Integer> getInformationAndSettingsResource() {
        return informationAndSettingsResource;
    }

    private ArrayList<Integer> getWhatToDo(){
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(R.string.what_to_do_element_1);
        list.add(R.string.what_to_do_element_2);
        list.add(R.string.what_to_do_element_3);
        list.add(R.string.what_to_do_element_4);
        list.add(R.string.what_to_do_element_5);
        list.add(R.string.what_to_do_element_6);
        list.add(R.string.what_to_do_element_7);
        list.add(R.string.what_to_do_element_8);
        list.add(R.string.what_to_do_element_9);
        list.add(R.string.what_to_do_element_10);
        list.add(R.string.what_to_do_element_11);
        list.add(R.string.what_to_do_element_12);
        list.add(R.string.what_to_do_element_13);
        list.add(R.string.what_to_do_element_14);
        list.add(R.string.what_to_do_element_15);
        list.add(R.string.what_to_do_element_16);
        list.add(R.string.what_to_do_element_17);
        list.add(R.string.what_to_do_element_18);
        list.add(R.string.what_to_do_element_19);
        list.add(R.string.what_to_do_element_20);
        list.add(R.string.what_to_do_element_21);
        list.add(R.string.what_to_do_element_22);
        list.add(R.string.what_to_do_element_23);
        list.add(R.string.what_to_do_element_24);
        list.add(R.string.what_to_do_element_25);
        list.add(R.string.what_to_do_element_26);
        list.add(R.string.what_to_do_element_27);
        list.add(R.string.what_to_do_element_28);
        list.add(R.string.what_to_do_element_29);
        list.add(R.string.what_to_do_element_30);
        list.add(R.string.what_to_do_element_31);
        list.add(R.string.what_to_do_element_32);
        list.add(R.string.what_to_do_element_33);
        list.add(R.string.what_to_do_element_34);
        list.add(R.string.what_to_do_element_35);
        list.add(R.string.what_to_do_element_36);
        list.add(R.string.what_to_do_element_37);
        list.add(R.string.what_to_do_element_38);
        list.add(R.string.what_to_do_element_39);

        return list;
    }

    private ArrayList<Integer> getFirstAid() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(R.string.first_aid_element_1);
        list.add(R.string.first_aid_element_2);
        list.add(R.string.first_aid_element_3);
        list.add(R.string.first_aid_element_4);
        list.add(R.string.first_aid_element_5);
        list.add(R.string.first_aid_element_6);
        list.add(R.string.first_aid_element_7);
        list.add(R.string.first_aid_element_8);
        list.add(R.string.first_aid_element_9);
        list.add(R.string.first_aid_element_10);
        list.add(R.string.first_aid_element_11);
        list.add(R.string.first_aid_element_12);
        list.add(R.string.first_aid_element_13);
        list.add(R.string.first_aid_element_14);

        return list;
    }

    private ArrayList<Integer> getMapOfAdverseEvents() {
        ArrayList<Integer> list = new ArrayList<Integer>();


        return list;
    }

    private ArrayList<Integer> getCheckYourSelf() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(R.string.check_your_self_element_1);
        list.add(R.string.check_your_self_element_2);
        list.add(R.string.check_your_self_element_3);
        list.add(R.string.check_your_self_element_4);
        list.add(R.string.check_your_self_element_5);
        list.add(R.string.check_your_self_element_6);
        list.add(R.string.check_your_self_element_7);
        list.add(R.string.check_your_self_element_8);
        list.add(R.string.check_your_self_element_9);
        list.add(R.string.check_your_self_element_10);
        list.add(R.string.check_your_self_element_11);
        list.add(R.string.check_your_self_element_12);
        list.add(R.string.check_your_self_element_13);
        list.add(R.string.check_your_self_element_14);
        list.add(R.string.check_your_self_element_15);
        list.add(R.string.check_your_self_element_16);
        list.add(R.string.check_your_self_element_17);
        list.add(R.string.check_your_self_element_18);
        list.add(R.string.check_your_self_element_19);
        list.add(R.string.check_your_self_element_20);

        return list;
    }

    private ArrayList<Integer> getEncyclopedia() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(R.string.encyclopedia_element_1);
        list.add(R.string.encyclopedia_element_2);
        list.add(R.string.encyclopedia_element_3);
        list.add(R.string.encyclopedia_element_4);
        list.add(R.string.encyclopedia_element_5);
        list.add(R.string.encyclopedia_element_6);
        list.add(R.string.encyclopedia_element_7);
        list.add(R.string.encyclopedia_element_8);
        list.add(R.string.encyclopedia_element_9);
        list.add(R.string.encyclopedia_element_10);
        list.add(R.string.encyclopedia_element_11);
        list.add(R.string.encyclopedia_element_12);
        list.add(R.string.encyclopedia_element_13);
        list.add(R.string.encyclopedia_element_14);
        list.add(R.string.encyclopedia_element_15);
        list.add(R.string.encyclopedia_element_16);
        list.add(R.string.encyclopedia_element_17);
        list.add(R.string.encyclopedia_element_18);
        list.add(R.string.encyclopedia_element_19);
        list.add(R.string.encyclopedia_element_20);
        list.add(R.string.encyclopedia_element_21);
        list.add(R.string.encyclopedia_element_22);
        list.add(R.string.encyclopedia_element_23);

        return list;
    }

    private ArrayList<Integer> getInformationAndSettings() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(R.string.information_and_settings_element_1);
        list.add(R.string.information_and_settings_element_2);
        list.add(R.string.information_and_settings_element_3);
        list.add(R.string.information_and_settings_element_4);

        return list;
    }


}
