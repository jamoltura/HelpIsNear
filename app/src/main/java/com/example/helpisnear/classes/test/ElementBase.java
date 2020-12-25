package com.example.helpisnear.classes.test;

import androidx.annotation.NonNull;

public class ElementBase {
    private String language;
    private String number;
    private String date_time;
    private String result_persent;
    private String non_answers;
    private String true_answer;
    private String false_answer;
    private String time_spend;
    private String ball;

    public ElementBase() {
        this.language = "";
        this.number = "";
        this.date_time = "";
        this.result_persent = "";
        this.non_answers = "";
        this.true_answer = "";
        this.false_answer = "";
        this.time_spend = "";
        this.ball = "";
    }

    public ElementBase(@NonNull String language, @NonNull String number, @NonNull String date_time,
                       @NonNull String result_persent, @NonNull String non_answers, @NonNull String true_answer,
                       @NonNull String false_answer, @NonNull String time_spend, @NonNull String ball) {
        this.language = language;
        this.number = number;
        this.date_time = date_time;
        this.result_persent = result_persent;
        this.non_answers = non_answers;
        this.true_answer = true_answer;
        this.false_answer = false_answer;
        this.time_spend = time_spend;
        this.ball = ball;
    }

    public void setElement(@NonNull String language, @NonNull String number, @NonNull String date_time,
                           @NonNull String result_persent, @NonNull String non_answers, @NonNull String true_answer,
                           @NonNull String false_answer, @NonNull String time_spend, @NonNull String ball){
        this.language = language;
        this.number = number;
        this.date_time = date_time;
        this.result_persent = result_persent;
        this.non_answers = non_answers;
        this.true_answer = true_answer;
        this.false_answer = false_answer;
        this.time_spend = time_spend;
        this.ball = ball;
    }

    public boolean isEmpyte(){
        return language.isEmpty();
    }

    public String getLanguage() {
        return language;
    }

    public String getNumber() {
        return number;
    }

    public String getDate_time() {
        return date_time;
    }

    public String getResult_persent() {
        return result_persent;
    }

    public String getNon_answers() {
        return non_answers;
    }

    public String getTrue_answer() {
        return true_answer;
    }

    public String getFalse_answer() {
        return false_answer;
    }

    public String getTime_spend() {
        return time_spend;
    }

    public String getBall() {
        return ball;
    }
}
