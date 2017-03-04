package com.sumeeth.webapp.service;

import com.google.gson.Gson;
import com.sumeeth.webapp.data.dao.QuestionDao;
import com.sumeeth.webapp.data.dto.Question;
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
    public List<Question> getAllQuestions() {
        return questionDao.getAllQuestions();
    }

    @Override
    public List<Question> getAllQuestoinsByCategory(int category) {

        return questionDao.getAllQuestoinsByCategory(category);
    }

    @Override
    public String toJson(List<Question> questionsList) {
        Gson gson = new Gson();
        return gson.toJson(questionsList).toString();
    }

   /* @Override
    public JSONObject toJsonObject(List<Question> questionsList){
        JSONObject json = new JSONObject();
        Field map = null;
        try {
            map = json.getClass().getDeclaredField("map");
            map.setAccessible(true);//because the field is private final...
            map.set(json, new LinkedHashMap<>());
            map.setAccessible(false);//return flag

            json.t
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/


}
