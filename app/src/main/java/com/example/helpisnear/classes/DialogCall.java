package com.example.helpisnear.classes;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.helpisnear.R;

public class DialogCall extends DialogFragment {

    private static final String TAG = "myLogs";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE, R.style.CallDialog);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.call_dialog, null);

        Button btn_call = v.findViewById(R.id.dialog_btn_call);
        Button btn_setting = v.findViewById(R.id.dialog_btn_setting);
        Button btn_close = v.findViewById(R.id.dialog_btn_close);

        btn_call.setOnClickListener((v1 -> Toast.makeText(getContext(), "calling", Toast.LENGTH_SHORT)));
        btn_setting.setOnClickListener((v1 -> Toast.makeText(getContext(), "setting", Toast.LENGTH_SHORT)));
        btn_close.setOnClickListener((v1 -> dismiss()));

        return v;
    }
}
