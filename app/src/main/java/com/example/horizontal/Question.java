package com.example.horizontal;

public class Question {
    private int textResId;
    private boolean answer;

    public Question(){}
    public Question(int textResId, boolean answer) {
        this.textResId = textResId;
        this.answer = answer;
    }

    public int getTextResId() {
        return textResId;
    }

    public void setTextResId(int textResId) {
        this.textResId = textResId;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
