package com.sumeeth.webapp.data.dto;

/**
 * Created by daljit on 29-Jan-17.
 */
public class Option {

    private static final String OPTION_SEPARATOR = ";";
    private static final String OPTION_CODE_SEPARATOR = ":";
    private static final String OPTION_CORRECT_SEPARATOR = ":";

    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String key;

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Option{" +
                "A='" + optionA + '\'' +
                ",B='" + optionB + '\'' +
                ",C='" + optionC + '\'' +
                ",D='" + optionD + '\'' +
                ",Key='" + key + '\'' +
                '}';
    }
}
