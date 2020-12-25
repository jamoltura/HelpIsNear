package com.example.helpisnear.classes.test;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class ControlTest {

    private static final String TAG = "myLogs";

    private static ControlTest controlTest;

    private Context context;
    private final String language;
    private final int index;
    private Test.TestList testList;
    private HistoryTestForBase base;
    private ElementBase mElementBase;
    private boolean WorthyOfPreservation;
    private long timeTest;
    private long time;
    private String mStartDateTimeForTest;
    private String mCurrentTimeTest;
    private CallBack callback;

    public interface CallBack{
        void setText(String value);
    }

    public static ControlTest getInstance(Context context){
        return controlTest;
    }

    public ControlTest(Context context, Test.TestList testList, String language, int index) {
        this.testList = testList;
        this.language = language;
        this.context = context;
        this.index = index;
        setTime(testList.getTime());
        base = new HistoryTestForBase(context);
        mElementBase = base.getBase(context, language, String.valueOf(index));
        mCurrentTimeTest = "";
        controlTest = this;
    }

    public void registerCallBack(CallBack callback){
        this.callback = callback;
    }

    public void startTest(){
        mStartDateTimeForTest = getDateTime();
        countDownTimer.start();
    }

    public void stopTest(){
        countDownTimer.cancel();
        _stopTest();
    }

    private void _stopTest(){
        saveTestBase();
    }

    public void saveTestBase(){

        ElementBase mElementBase = excuteTest();

        if (isWorthyOfPreservation()) {
            base.saveBase(context, mElementBase);
        }
    }

    private ElementBase excuteTest(){

        ArrayList<OnlyTest> list = testList.getOnlyTests();

        int count = list.size();

        int ball = 0;
        int not_answer = 0;
        int false_answer = 0;
        int true_answer = 0;

        if (count > 0){
            for (int i = 0; i < count; i++){
                ball += list.get(i).ball();
                not_answer = list.get(i).not_answer();
                false_answer = list.get(i).false_answer();
                true_answer = list.get(i).true_answer();
            }
        }

        ball %= getTimeTest();

        double persent = 0;

        if (true_answer > 0) {
            persent = count / true_answer * 100;
        }else {
            persent = 0;
        }

        long _time = getTime() - getTimeTest();

        if (mElementBase.isEmpyte()){
            setWorthyOfPreservation(true);
        }else {
            int mBall = Integer.parseInt(mElementBase.getBall());
            setWorthyOfPreservation(mBall <= ball);
        }

        return new ElementBase(language, String.valueOf(index), mStartDateTimeForTest, String.valueOf(persent),
                String.valueOf(not_answer), String.valueOf(true_answer), String.valueOf(false_answer),
                String.valueOf(_time), String.valueOf(ball));
    }

    private String getDateTime(){
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Calendar cal_s = Calendar.getInstance();
        return format.format(cal_s.getTime());
    }


    public String getTestTime() {

        SimpleDateFormat format = new SimpleDateFormat("mm:ss");

        Calendar cal_s = Calendar.getInstance();

        Date date = new Date();
        date.setTime(getTime());

        try {
            cal_s.setTime(Objects.requireNonNull(format.parse(format.format(date))));
        } catch (ParseException e) {
            Log.d(TAG, e.getMessage());
            return "00:00";
        }

        return format.format(cal_s.getTime());
    }

    private String getCurrentTimeTest() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("mm:ss");

        Calendar cal_s = Calendar.getInstance();

        if (mCurrentTimeTest.isEmpty()) {
            mCurrentTimeTest = getTestTime();
        }else {
            cal_s.setTime(Objects.requireNonNull(format.parse(mCurrentTimeTest)));
            cal_s.roll(Calendar.SECOND, false);
            mCurrentTimeTest = format.format(cal_s.getTime());
        }
        return mCurrentTimeTest;
    }

    private final CountDownTimer countDownTimer = new CountDownTimer(getTime(), 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            setTimeTest(getTimeTest() - 1000);
            try {
                callback.setText(getCurrentTimeTest());
            } catch (ParseException e) {
                Log.d(TAG, e.getMessage());
            }
        }

        @Override
        public void onFinish() {
            _stopTest();
        }
    };

    public Test.TestList getTestList() {
        return testList;
    }

    public void setTestList(Test.TestList testList) {
        this.testList = testList;
    }

    public ElementBase getmElementBase() {
        return mElementBase;
    }

    public boolean isWorthyOfPreservation() {
        return WorthyOfPreservation;
    }

    public void setWorthyOfPreservation(boolean worthyOfPreservation) {
        WorthyOfPreservation = worthyOfPreservation;
    }

    public long getTimeTest() {
        return timeTest;
    }

    public void setTimeTest(long timeTest) {
        this.timeTest = timeTest;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
