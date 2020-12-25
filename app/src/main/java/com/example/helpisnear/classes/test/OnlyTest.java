package com.example.helpisnear.classes.test;

public class OnlyTest {
    private String question;
    private String[] answers;
    private int[] isAnswer;
    private int[] answerForUser;
    public static final int COUNT_ANSWER = 4;

    public OnlyTest() {
        this.question = "";
        this.answers = emptyAnswers();
        this.isAnswer = emptyIsAnswer();
        this.answerForUser = emptyIsAnswer();
    }

    public OnlyTest(String question, String[] answers, int[] isAnswer) {
        this.question = question;
        this.answers = answers;
        this.isAnswer = isAnswer;
        this.answerForUser = emptyIsAnswer();
    }

    public static String[] emptyAnswers(){
        String[] answers = new String[COUNT_ANSWER];
        answers[0] = "";
        answers[1] = "";
        answers[2] = "";
        answers[3] = "";
        return answers;
    }

    public static int[] emptyIsAnswer(){
        int[] isAnswer = new int[COUNT_ANSWER];
        isAnswer[0] = 0;
        isAnswer[1] = 0;
        isAnswer[2] = 0;
        isAnswer[3] = 0;
        return isAnswer;
    }

    public int ball(){
        int mBall = 0;

        mBall += ball_Answer_a();
        mBall += ball_Answer_b();
        mBall += ball_Answer_c();
        mBall += ball_Answer_d();

        return mBall;
    }

    public int ball_Answer_a(){

        int ball = 0;

        if (isAnswer[0] == 0){
            if (isAnswer[0] != answerForUser[0]){
                ball--;
            }
        }else {
            if (isAnswer[0] == answerForUser[0]){
                ball++;
            }
        }

        return ball;
    }

    public int ball_Answer_b(){
        int ball = 0;

        if (isAnswer[1] == 0){
            if (isAnswer[1] != answerForUser[1]){
                ball--;
            }
        }else {
            if (isAnswer[1] == answerForUser[1]){
                ball++;
            }
        }

        return ball;
    }

    public int ball_Answer_c(){
        int ball = 0;

        if (isAnswer[2] == 0){
            if (isAnswer[2] != answerForUser[2]){
                ball--;
            }
        }else {
            if (isAnswer[2] == answerForUser[2]){
                ball++;
            }
        }

        return ball;
    }

    public int ball_Answer_d(){
        int ball = 0;

        if (isAnswer[3] == 0){
            if (isAnswer[3] != answerForUser[3]){
                ball--;
            }
        }else {
            if (isAnswer[3] == answerForUser[3]){
                ball++;
            }
        }

        return ball;
    }

    public int not_answer(){
        if (answerForUser[0] == 0 && answerForUser[1] == 0 && answerForUser[2] == 0 && answerForUser[3] == 0){
            return 1;
        }else {
            return 0;
        }
    }

    public int false_answer(){
        int false_count = 0;

        if (isAnswer[0] == 0){
            if (answerForUser[0] == 1) {
                false_count++;
            }
        }

        if (isAnswer[1] == 0){
            if (answerForUser[1] == 1) {
                false_count++;
            }
        }

        if (isAnswer[2] == 0){
            if (answerForUser[2] == 1) {
                false_count++;
            }
        }

        if (isAnswer[3] == 0){
            if (answerForUser[3] == 1) {
                false_count++;
            }
        }

        return false_count;
    }

    public int true_answer(){
        int true_count = 0;

        if (isAnswer[0] == 1){
            if (answerForUser[0] == 1) {
                true_count++;
            }
        }

        if (isAnswer[1] == 1){
            if (answerForUser[1] == 1) {
                true_count++;
            }
        }

        if (isAnswer[2] == 1){
            if (answerForUser[2] == 1) {
                true_count++;
            }
        }

        if (isAnswer[3] == 1){
            if (answerForUser[3] == 1) {
                true_count++;
            }
        }

        return true_count;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public int[] getIsAnswer() {
        return isAnswer;
    }

    public int[] getAnswerForUser() {
        return answerForUser;
    }

    public void setAnswerForUser(int[] answerForUser) {
        this.answerForUser = answerForUser;
    }
}
