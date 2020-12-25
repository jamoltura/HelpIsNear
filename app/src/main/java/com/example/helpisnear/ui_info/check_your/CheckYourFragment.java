package com.example.helpisnear.ui_info.check_your;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

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
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.helpisnear.R;
import com.example.helpisnear.activites.InfoActivity;
import com.example.helpisnear.activites.WindowTestActivity;
import com.example.helpisnear.adapters.TestListAdapter;
import com.example.helpisnear.classes.LocaleHelper;
import com.example.helpisnear.classes.test.ControlTest;
import com.example.helpisnear.classes.test.Test;
import com.example.helpisnear.model.HomeViewModel;

import java.util.ArrayList;

public class CheckYourFragment extends Fragment {

    private HomeViewModel mViewModel;

    private int index;

    private RelativeLayout rl_start;
    private RelativeLayout rl_continue;
    private RecyclerView recyclerView;

    private TextView body_test_list;
    private TextView text_count_test_start;
    private TextView text_time_test_start;
    private Button btn_start_test;

    private TextView text_count_test_continue;
    private TextView text_time_test_continue;
    private TextView text_time_history;
    private TextView text_percent_history;
    private TextView text_coment_history;
    private TextView text_non_ans_history;
    private TextView text_true_ans_history;
    private TextView text_false_ans_history;
    private TextView text_time_span_ans_history;
    private Button btn_start_test2;

    private TestListAdapter adapter;

    private int LAUNCH_ACTIVITY= 1;

    public static CheckYourFragment newInstance() {
        return new CheckYourFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.check_your_fragment, container, false);

        rl_start = view.findViewById(R.id.rl_start);
        rl_continue = view.findViewById(R.id.rl_continue);
        recyclerView = view.findViewById(R.id.recycler_test_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        body_test_list = view.findViewById(R.id.body_test_list);

        text_count_test_start = view.findViewById(R.id.text_count_test_start);
        text_time_test_start = view.findViewById(R.id.text_time_test_start);
        btn_start_test = view.findViewById(R.id.btn_start_test);

        text_count_test_continue = view.findViewById(R.id.text_count_test_continue);
        text_time_test_continue = view.findViewById(R.id.text_time_test_continue);
        text_time_history = view.findViewById(R.id.text_time_history);
        text_percent_history = view.findViewById(R.id.text_percent_history);
        text_coment_history = view.findViewById(R.id.text_coment_history);
        text_non_ans_history = view.findViewById(R.id.text_non_ans_history);
        text_true_ans_history = view.findViewById(R.id.text_true_ans_history);
        text_false_ans_history = view.findViewById(R.id.text_false_ans_history);
        text_time_span_ans_history = view.findViewById(R.id.text_time_span_ans_history);
        btn_start_test2 = view.findViewById(R.id.btn_start_test2);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(getActivity()).get(HomeViewModel.class);

        String position = this.getArguments().getString("position");
        String header = this.getArguments().getString("header");

        setIndex(Integer.parseInt(position));

        mViewModel.getDataTest().observe(getViewLifecycleOwner(), testLists -> {

            Test.TestList testList = testLists.get(getIndex());

            String countTest = String.valueOf(testList.getOnlyTests().size());

            String lang = LocaleHelper.getLanguage(getActivity().getApplicationContext());

            ControlTest controlTest = new ControlTest(getContext(), testList, lang, getIndex());

            if (controlTest.getmElementBase().isEmpyte()){

                rl_continue.setVisibility(View.GONE);

                body_test_list.setText(header);

                countTest += " " + text_count_test_start.getText().toString();

                text_count_test_start.setText(countTest);

                text_time_test_start.setText(controlTest.getTestTime());

                btn_start_test.setOnClickListener(click);
            }else {
                rl_start.setVisibility(View.GONE);

                countTest += " " + text_count_test_continue.getText().toString();

                text_count_test_continue.setText(countTest);

                text_time_test_continue.setText(controlTest.getTestTime());

                text_time_history.setText(controlTest.getmElementBase().getDate_time());
                text_percent_history.setText(controlTest.getmElementBase().getResult_persent());
              //  text_coment_history.setText(controlTest.getmElementBase().getDate_time());
                text_non_ans_history.setText(controlTest.getmElementBase().getNon_answers());
                text_true_ans_history.setText(controlTest.getmElementBase().getTrue_answer());
                text_false_ans_history.setText(controlTest.getmElementBase().getFalse_answer());
                text_time_span_ans_history.setText(controlTest.getmElementBase().getTime_spend());

                btn_start_test2.setOnClickListener(click);
            }

            adapter = new TestListAdapter(getContext(), R.layout.item_list_arrow_test, testList);

            recyclerView.setAdapter(adapter);
        });
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

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getContext(), WindowTestActivity.class);
            intent.putExtra("position", String.valueOf(getIndex()));
            startActivityForResult(intent, LAUNCH_ACTIVITY);
        }
    };

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}