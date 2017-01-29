package com.sumeeth.webapp.data.dto;

/**
 * Created by daljit on 29-Jan-17.
 */
public class Answer {


    private int questionNo;
    private String key;

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "questionNo='" + questionNo + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
