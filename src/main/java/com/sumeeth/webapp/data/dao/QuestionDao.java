package com.sumeeth.webapp.data.dao;

import com.sumeeth.webapp.data.dto.Questions;

import java.util.List;

/**
 * Created by daljit on 29-Jan-17.
 */
public interface QuestionDao {

    List<Questions> getAllQuestions();

    List<Questions> getAllQuestoinsByCategory(int category);

}
