package com.sumeeth.webapp.service;

import com.sumeeth.webapp.data.dao.QuestionDao;
import com.sumeeth.webapp.data.dto.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by daljit on 29-Jan-17.
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionDao questionDao;

    @Override
    public List<Questions> getAllQuestions() {
        return questionDao.getAllQuestions();
    }

    @Override
    public List<Questions> getAllQuestoinsByCategory(int category) {

        return questionDao.getAllQuestoinsByCategory(category);
    }
}
