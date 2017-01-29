package com.sumeeth.webapp.util;

import com.sumeeth.webapp.data.dto.Answer;
import com.sumeeth.webapp.data.dto.Option;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by daljit on 29-Jan-17.
 */
public class QuestionUtil {

    public static final String OPTION_KEY = "option";
    public static final String ANSWER_KEY = "answer";
    private static final String OPTION_SEPARATOR = ";";
    private static final String OPTION_CODE_SEPARATOR = ":";
    private static final String OPTION_A = "A:";
    private static final String OPTION_B = "B:";
    private static final String OPTION_C = "C:";
    private static final String OPTION_D = "D:";
    private static final String OPTION_ANS = "ANS:C";

    /*public static void main(String[] args) {
        String option = "A:Mumbai;B:Kolkata;C:New Delhi;D:NOTA;ANS:C";
        System.out.println(getFormattedOption(option));
    }
*/
    public static Map<String, Object> getFormattedOption(String rawOption) {
        Map<String, Object> optionWithAnwer = new HashMap();
        Answer answer = new Answer();
        Option option = new Option();
        String[] options = rawOption.split(OPTION_SEPARATOR);
        Arrays.asList(options).stream().forEach(i -> getOptionObject(option, answer, i));
        optionWithAnwer.put(OPTION_KEY, option);
        optionWithAnwer.put(ANSWER_KEY, answer);
        return optionWithAnwer;
    }

    public static void getOptionObject(Option option, Answer answer, String op) {
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
        } else if (null != op && op.startsWith(OPTION_ANS)) {
            optionWithCode = op.split(OPTION_CODE_SEPARATOR);
            answer.setKey(optionWithCode[1]);
        }


    }

}
