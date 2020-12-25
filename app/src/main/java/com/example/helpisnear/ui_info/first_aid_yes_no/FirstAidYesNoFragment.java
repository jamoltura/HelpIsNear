package com.example.helpisnear.ui_info.first_aid_yes_no;

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
import com.example.helpisnear.activites.FirstAidYesActivity;
import com.example.helpisnear.activites.InfoActivity;
import com.example.helpisnear.model.HomeViewModel;

public class FirstAidYesNoFragment extends Fragment {

    private static final String TAG = "myLogs";

    private HomeViewModel mViewModel;

    private Button btn_yes;
    private Button btn_no;
    private int index;
    private int LAUNCH_ACTIVITY= 1;


    public static FirstAidYesNoFragment newInstance() {
        return new FirstAidYesNoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.first_aid_yes_no_fragment, container, false);

        btn_yes = view.findViewById(R.id.question_btn_yes);
        btn_yes.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), FirstAidYesActivity.class);
            startActivityForResult(intent, LAUNCH_ACTIVITY);
        });

        btn_no = view.findViewById(R.id.question_btn_no);
        btn_no.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), InfoActivity.class);
            intent.putExtra("type_info", "FirstAid");
            intent.putExtra("position", String.valueOf(getIndex()));
            startActivityForResult(intent, LAUNCH_ACTIVITY);
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(getActivity()).get(HomeViewModel.class);

        String position = this.getArguments().getString("position");

        setIndex(Integer.parseInt(position));

        // TODO: Use the ViewModel
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LAUNCH_ACTIVITY) {
            if (resultCode == Activity.RESULT_OK) {

                int value = data.getIntExtra("result", -1);

                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", value);
                getActivity().setResult(Activity.RESULT_OK, returnIntent);
                getActivity().finish();

            }
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}