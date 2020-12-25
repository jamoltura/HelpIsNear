package com.example.helpisnear.classes.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import static android.content.Context.MODE_PRIVATE;

public class HistoryTestForBase {

    private final String NAME_BASE = "test.db";
    private final String TABLE_TEST = "table_test";

    private final String KEY_ID = "_id";
    private final String LANGUAGE = "language";
    private final String NUMBER = "number";
    private final String DATE_TIME = "date_time";
    private final String RESULT_PERSENT = "result_persent";
    private final String NON_ANSWER = "non_answers";
    private final String TRUE_ANSWER = "true_answer";
    private final String FALSE_ANSWER = "false_answer";
    private final String TIME_SPEND = "time_spend";
    private final String BALL = "ball";


    public HistoryTestForBase(Context context) {
        SQLiteDatabase db = context.openOrCreateDatabase(NAME_BASE, MODE_PRIVATE, null);
        String _KEY_ID = KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT";
        String _LANGUAGE = LANGUAGE + " TEXT";
        String _NUMBER = NUMBER + " TEXT";
        String _DATE_TIME = DATE_TIME + " TEXT";
        String _RESULT_PERSENT = RESULT_PERSENT + " TEXT";
        String _NON_ANSWER = NON_ANSWER + " TEXT";
        String _TRUE_ANSWER = TRUE_ANSWER + " TEXT";
        String _FALSE_ANSWER = FALSE_ANSWER + " TEXT";
        String _TIME_SPEND = TIME_SPEND + " TEXT";
        String _BALL = BALL + " TEXT";

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_TEST
                + " ("+_KEY_ID+", "+_LANGUAGE+", "+_NUMBER+", "+_DATE_TIME+", "+_RESULT_PERSENT+", " +
                ""+_NON_ANSWER+", "+_TRUE_ANSWER+", "+_FALSE_ANSWER+", "+_TIME_SPEND+", "+_BALL+")");
        db.close();
    }

    public boolean saveBase(Context context, ElementBase elementBase){

        ElementBase base = getBase(context, elementBase.getLanguage(), elementBase.getNumber());

        if (base.isEmpyte()){
            return save(context, elementBase);
        }else {
            return update(context, elementBase);
        }
    }

    private boolean save(Context context, ElementBase elementBase){
        SQLiteDatabase db = context.openOrCreateDatabase(NAME_BASE, MODE_PRIVATE, null);
        ContentValues values = new ContentValues();

        values.put(LANGUAGE, elementBase.getLanguage());
        values.put(NUMBER, elementBase.getNumber());
        values.put(DATE_TIME, elementBase.getDate_time());
        values.put(RESULT_PERSENT, elementBase.getResult_persent());
        values.put(NON_ANSWER, elementBase.getNon_answers());
        values.put(TRUE_ANSWER, elementBase.getTrue_answer());
        values.put(FALSE_ANSWER, elementBase.getFalse_answer());
        values.put(TIME_SPEND, elementBase.getTime_spend());
        values.put(BALL, elementBase.getBall());

        long index = db.insert(TABLE_TEST, null, values);
        db.close();
        return index != -1;
    }

    public ElementBase getBase(Context context, String language, String number){

        SQLiteDatabase db = context.openOrCreateDatabase(NAME_BASE, MODE_PRIVATE, null);
        String whereClause = LANGUAGE + "=? AND " + NUMBER + "=?";
        String[] whereArgs = new String[]{language, number};

        Cursor query = db.query(TABLE_TEST, null, whereClause, whereArgs, null, null, null);

        ElementBase elementBase = new ElementBase();

        if (query.moveToFirst()){

            String date_time = query.getString(3);
            String result_persent = query.getString(4);
            String non_answer = query.getString(5);
            String true_answer = query.getString(6);
            String false_answer = query.getString(7);
            String time_spend = query.getString(8);
            String ball = query.getString(9);

            elementBase.setElement(language, number, date_time, result_persent, non_answer, true_answer, false_answer, time_spend, ball);
        }
        query.close();
        db.close();
        return elementBase;
    }

    private boolean update(Context context, ElementBase elementBase){
        SQLiteDatabase db = context.openOrCreateDatabase(NAME_BASE, MODE_PRIVATE, null);
        ContentValues values = new ContentValues();

        values.put(LANGUAGE, elementBase.getLanguage());
        values.put(NUMBER, elementBase.getNumber());
        values.put(DATE_TIME, elementBase.getDate_time());
        values.put(RESULT_PERSENT, elementBase.getResult_persent());
        values.put(NON_ANSWER, elementBase.getNon_answers());
        values.put(TRUE_ANSWER, elementBase.getTrue_answer());
        values.put(FALSE_ANSWER, elementBase.getFalse_answer());
        values.put(TIME_SPEND, elementBase.getTime_spend());
        values.put(BALL, elementBase.getBall());

        String whereClause = LANGUAGE + "=? AND " + NUMBER + "=?";
        String[] whereArgs = new String[]{elementBase.getLanguage(), elementBase.getNumber()};

        int indexUpdate = db.update(TABLE_TEST, values, whereClause, whereArgs);

        db.close();

        return indexUpdate == 1;
    }
}
