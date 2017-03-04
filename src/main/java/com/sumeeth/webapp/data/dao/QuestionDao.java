package com.sumeeth.webapp.data.dao;

import com.sumeeth.webapp.data.dto.Question;

import java.util.List;

/**
 * Created by daljit on 29-Jan-17.
 */
public interface QuestionDao {

    List<Question> getAllQuestions();

    List<Question> getAllQuestoinsByCategory(int category);

}
