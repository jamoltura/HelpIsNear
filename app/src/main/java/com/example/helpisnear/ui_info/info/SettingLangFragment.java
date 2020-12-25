package com.example.helpisnear.ui_info.info;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.helpisnear.R;
import com.example.helpisnear.classes.LocaleHelper;
import com.example.helpisnear.model.HomeViewModel;

public class SettingLangFragment extends Fragment {

    private HomeViewModel mViewModel;

    private Button btn_lang;
    private Button btn_ru;
    private Button btn_uz_k;
    private Button btn_uz_l;
    private Button btn_en;

    private int index;

    public static SettingLangFragment newInstance() {
        return new SettingLangFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.setting_lang_fragment, container, false);

        String lang = LocaleHelper.getLanguage(getActivity().getApplicationContext());

        btn_lang = v.findViewById(R.id.btn_lang);
        btn_ru = v.findViewById(R.id.btn_ru);
        btn_uz_k = v.findViewById(R.id.btn_uz_k);
        btn_uz_l = v.findViewById(R.id.btn_uz_l);
        btn_en = v.findViewById(R.id.btn_en);

        btn_lang.setOnClickListener(click);
        btn_ru.setOnClickListener(click);
        btn_uz_k.setOnClickListener(click);
        btn_uz_l.setOnClickListener(click);
        btn_en.setOnClickListener(click);


        if (lang.equalsIgnoreCase("ru")){
            btn_ru.setBackgroundResource(R.drawable.btnsimple_select);
            btn_ru.setTextColor(getResources().getColor(R.color.white));
        }else if (lang.equalsIgnoreCase("uz")){
            btn_uz_l.setBackgroundResource(R.drawable.btnsimple_select);
            btn_uz_l.setTextColor(getResources().getColor(R.color.white));
        }else if (lang.equalsIgnoreCase("en")){
            btn_en.setBackgroundResource(R.drawable.btnsimple_select);
            btn_en.setTextColor(getResources().getColor(R.color.white));
        }else {
            btn_uz_k.setBackgroundResource(R.drawable.btnsimple_select);
            btn_uz_k.setTextColor(getResources().getColor(R.color.white));
        }

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);


        // TODO: Use the ViewModel
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            btn_ru.setBackgroundResource(R.drawable.btnsimple);
            btn_ru.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

            btn_uz_l.setBackgroundResource(R.drawable.btnsimple);
            btn_uz_l.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

            btn_en.setBackgroundResource(R.drawable.btnsimple);
            btn_en.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

            btn_uz_k.setBackgroundResource(R.drawable.btnsimple);
            btn_uz_k.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

            String lang = LocaleHelper.getLanguage(getActivity().getApplicationContext());

            switch (v.getId()){
                case R.id.btn_lang:
                    String value = btn_lang.getText().toString();
                    if (value.equals(getResources().getString(R.string.text_btn_lang_close))){
                        Intent returnIntent = new Intent();
                        getActivity().setResult(Activity.RESULT_CANCELED, returnIntent);
                        getActivity().finish();
                    }else{
                        Intent returnIntent = new Intent();
                        returnIntent.putExtra("result", getIndex());
                        getActivity().setResult(Activity.RESULT_OK, returnIntent);
                        getActivity().finish();
                    }
                    break;
                case R.id.btn_ru:
                    btn_ru.setBackgroundResource(R.drawable.btnsimple_select);
                    btn_ru.setTextColor(getResources().getColor(R.color.white));

                    if (lang.equalsIgnoreCase("ru")) {
                        btn_lang.setText(R.string.text_btn_lang_close);
                    }else {
                        btn_lang.setText(R.string.text_btn_lang_run);
                    }
                    setIndex(7);
                    break;
                case R.id.btn_uz_k:
                    btn_uz_k.setBackgroundResource(R.drawable.btnsimple_select);
                    btn_uz_k.setTextColor(getResources().getColor(R.color.white));

                    if (lang.equalsIgnoreCase("default")) {
                        btn_lang.setText(R.string.text_btn_lang_close);
                    }else {
                        btn_lang.setText(R.string.text_btn_lang_run);
                    }
                    setIndex(8);
                    break;
                case R.id.btn_uz_l:
                    btn_uz_l.setBackgroundResource(R.drawable.btnsimple_select);
                    btn_uz_l.setTextColor(getResources().getColor(R.color.white));

                    if (lang.equalsIgnoreCase("uz")) {
                        btn_lang.setText(R.string.text_btn_lang_close);
                    }else {
                        btn_lang.setText(R.string.text_btn_lang_run);
                    }
                    setIndex(9);
                    break;
                case R.id.btn_en:
                    btn_en.setBackgroundResource(R.drawable.btnsimple_select);
                    btn_en.setTextColor(getResources().getColor(R.color.white));

                    if (lang.equalsIgnoreCase("en")) {
                        btn_lang.setText(R.string.text_btn_lang_close);
                    }else {
                        btn_lang.setText(R.string.text_btn_lang_run);
                    }
                    setIndex(10);
            }
        }
    };

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}