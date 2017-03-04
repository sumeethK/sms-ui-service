package com.sumeeth.webapp.util;

import com.sumeeth.webapp.data.dto.Option;

import java.util.Arrays;

/**
 * Created by daljit on 29-Jan-17.
 */
public class QuestionUtil {

    private static final String OPTION_SEPARATOR = ";";
    private static final String OPTION_CODE_SEPARATOR = ":";
    private static final String OPTION_A = "A:";
    private static final String OPTION_B = "B:";
    private static final String OPTION_C = "C:";
    private static final String OPTION_D = "D:";
    private static final String OPTION_KEY = "ANS:";



/*
    public static void main(String[] args) {
        String option = "A:Mumbai;B:Kolkata;C:New Delhi;D:NOTA;ANS:C";
        System.out.println(getFormattedOption(option));
    }*/

    public static Option getFormattedOption(String rawOption) {
        Option option = new Option();
        String[] options = rawOption.split(OPTION_SEPARATOR);
        Arrays.asList(options).stream().forEach(i -> getOptionObject(option, i));
        return option;
    }

    public static Option getOptionObject(Option option, String op) {
        String[] optionWithCode;
        if (null != op && op.startsWith(OPTION_A)) {
            optionWithCode = op.split(OPTION_CODE_SEPARATOR);
            option.setOptionA(optionWithCode[1]);
        } else if (null != op && op.startsWith(OPTION_B)) {
            optionWithCode = op.split(OPTION_CODE_SEPARATOR);
            option.setOptionB(optionWithCode[1]);
        } else if (null != op && op.startsWith(OPTION_C)) {
            optionWithCode = op.split(OPTION_CODE_SEPARATOR);
            option.setOptionC(optionWithCode[1]);
        } else if (null != op && op.startsWith(OPTION_D)) {
            optionWithCode = op.split(OPTION_CODE_SEPARATOR);
            option.setOptionD(optionWithCode[1]);
        } else if (null != op && op.startsWith(OPTION_KEY)) {
            optionWithCode = op.split(OPTION_CODE_SEPARATOR);
            option.setKey(optionWithCode[1]);
        }

        return option;

    }

}
