package com.example.helpisnear.classes.test;

import android.content.res.Resources;

import java.util.ArrayList;
import com.example.helpisnear.R;

public class Test {

    private final ArrayList<TestList> testLists;

    public Test(Resources resources) {
        testLists = new ArrayList<>();
        testLists.add(new TestList(resources, 0, 300000));
        testLists.add(new TestList(resources, 1, 300000));
        testLists.add(new TestList(resources, 2, 300000));
        testLists.add(new TestList(resources, 3, 300000));
        testLists.add(new TestList(resources, 4, 300000));
    }

    public ArrayList<TestList> getTestLists() {
        return testLists;
    }

    public static class TestList{

        private ArrayList<OnlyTest> onlyTests;
        private long time;

        public TestList(Resources resources, int value, long time) {
            switch (value){
                case 0 :
                    onlyTests = getOnlyTests_1(resources);
                    this.time = time;
                    break;
                case 1:
                    onlyTests = getOnlyTests_2(resources);
                    this.time = time;
                    break;
                case 2:
                    onlyTests = getOnlyTests_3(resources);
                    this.time = time;
                    break;
                case 3:
                    onlyTests = getOnlyTests_4(resources);
                    this.time = time;
                    break;
                case 4:
                    onlyTests = getOnlyTests_5(resources);
                    this.time = time;
            }
        }

        public long getTime() {
            return time;
        }

        private ArrayList<OnlyTest> getOnlyTests_1(Resources resources){
            ArrayList<OnlyTest> list = new ArrayList<>();

            String[] ans = OnlyTest.emptyAnswers();
            int[] is_ans = OnlyTest.emptyIsAnswer();

            String question = resources.getString(R.string.question_0_0);
            ans[0] = resources.getString(R.string.answer_a_0_0);
            ans[1] = resources.getString(R.string.answer_b_0_0);
            ans[2] = resources.getString(R.string.answer_c_0_0);
            ans[3] = resources.getString(R.string.answer_d_0_0);
            is_ans[0] = Integer.parseInt(resources.getString(R.string.is_answer_a_0_0));
            is_ans[1] = Integer.parseInt(resources.getString(R.string.is_answer_b_0_0));
            is_ans[2] = Integer.parseInt(resources.getString(R.string.is_answer_c_0_0));
            is_ans[3] = Integer.parseInt(resources.getString(R.string.is_answer_d_0_0));

            list.add(new OnlyTest(question, ans, is_ans));

            question = resources.getString(R.string.question_1_0);
            ans[0] = resources.getString(R.string.answer_a_1_0);
            ans[1] = resources.getString(R.string.answer_b_1_0);
            ans[2] = resources.getString(R.string.answer_c_1_0);
            ans[3] = resources.getString(R.string.answer_d_1_0);
            is_ans[0] = Integer.parseInt(resources.getString(R.string.is_answer_a_1_0));
            is_ans[1] = Integer.parseInt(resources.getString(R.string.is_answer_b_1_0));
            is_ans[2] = Integer.parseInt(resources.getString(R.string.is_answer_c_1_0));
            is_ans[3] = Integer.parseInt(resources.getString(R.string.is_answer_d_1_0));

            list.add(new OnlyTest(question, ans, is_ans));

            question = resources.getString(R.string.question_2_0);
            ans[0] = resources.getString(R.string.answer_a_2_0);
            ans[1] = resources.getString(R.string.answer_b_2_0);
            ans[2] = resources.getString(R.string.answer_c_2_0);
            ans[3] = resources.getString(R.string.answer_d_2_0);
            is_ans[0] = Integer.parseInt(resources.getString(R.string.is_answer_a_2_0));
            is_ans[1] = Integer.parseInt(resources.getString(R.string.is_answer_b_2_0));
            is_ans[2] = Integer.parseInt(resources.getString(R.string.is_answer_c_2_0));
            is_ans[3] = Integer.parseInt(resources.getString(R.string.is_answer_d_2_0));

            list.add(new OnlyTest(question, ans, is_ans));

            question = resources.getString(R.string.question_3_0);
            ans[0] = resources.getString(R.string.answer_a_3_0);
            ans[1] = resources.getString(R.string.answer_b_3_0);
            ans[2] = resources.getString(R.string.answer_c_3_0);
            ans[3] = resources.getString(R.string.answer_d_3_0);
            is_ans[0] = Integer.parseInt(resources.getString(R.string.is_answer_a_3_0));
            is_ans[1] = Integer.parseInt(resources.getString(R.string.is_answer_b_3_0));
            is_ans[2] = Integer.parseInt(resources.getString(R.string.is_answer_c_3_0));
            is_ans[3] = Integer.parseInt(resources.getString(R.string.is_answer_d_3_0));

            list.add(new OnlyTest(question, ans, is_ans));

            question = resources.getString(R.string.question_4_0);
            ans[0] = resources.getString(R.string.answer_a_4_0);
            ans[1] = resources.getString(R.string.answer_b_4_0);
            ans[2] = resources.getString(R.string.answer_c_4_0);
            ans[3] = resources.getString(R.string.answer_d_4_0);
            is_ans[0] = Integer.parseInt(resources.getString(R.string.is_answer_a_4_0));
            is_ans[1] = Integer.parseInt(resources.getString(R.string.is_answer_b_4_0));
            is_ans[2] = Integer.parseInt(resources.getString(R.string.is_answer_c_4_0));
            is_ans[3] = Integer.parseInt(resources.getString(R.string.is_answer_d_4_0));

            list.add(new OnlyTest(question, ans, is_ans));

            return list;
        }

        private ArrayList<OnlyTest> getOnlyTests_2(Resources resources){
            ArrayList<OnlyTest> list = new ArrayList<>();

            return list;
        }

        private ArrayList<OnlyTest> getOnlyTests_3(Resources resources){
            ArrayList<OnlyTest> list = new ArrayList<>();

            return list;
        }

        private ArrayList<OnlyTest> getOnlyTests_4(Resources resources){
            ArrayList<OnlyTest> list = new ArrayList<>();

            return list;
        }

        private ArrayList<OnlyTest> getOnlyTests_5(Resources resources){
            ArrayList<OnlyTest> list = new ArrayList<>();

            return list;
        }

        public ArrayList<OnlyTest> getOnlyTests() {
            return onlyTests;
        }

    }


}
