package com.sumeeth.webapp.service;

import com.sumeeth.webapp.data.dto.Question;

import java.util.List;

/**
 * Created by daljit on 29-Jan-17.
 */
public interface QuestionService {

    List<Question> getAllQuestions();

    List<Question> getAllQuestoinsByCategory(int category);

    String toJson(List<Question> questionsList);

//    JSONObject toJsonObject(List<Question> questionsList);
}
