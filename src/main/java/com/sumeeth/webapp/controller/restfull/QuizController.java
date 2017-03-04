package com.sumeeth.webapp.controller.restfull;

import com.sumeeth.webapp.data.dto.Questions;
import com.sumeeth.webapp.service.QuestionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("quiz")
public class QuizController {
    private Logger log = Logger.getLogger(QuizController.class);


    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/getAllQuestion", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map getAllQuestion() {
        return generateResultMap(questionService.getAllQuestions());
    }


    private Map<String, Object> generateResultMap(List<Questions> qList) {
        Map<String, Object> map = new ModelMap();
        map.put("page_title", "quiz Offline");
        map.put("questionList", qList);
        map.put("totalQuestions", qList.size());
        map.put("rows_count", qList.size() / 10);
        map.put("rows_start", 1);
        map.put("rows_display", 10);
        return map;

    }


}
