package com.sumeeth.webapp.data.dao;

import com.sumeeth.webapp.data.dto.Questions;
import com.sumeeth.webapp.data.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by daljit on 29-Jan-17.
 */
@Repository
public class QuestionDaoImpl implements QuestionDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Questions> getAllQuestions() {

        //language=OracleSqlPlus
        String sql = "SELECT * FROM QUESTIONS_TABLE";
        List<Questions> questionsList = getJdbcTemplate().query(sql, new QuestionMapper());
        return questionsList;
    }

    @Override
    public List<Questions> getAllQuestoinsByCategory(int category) {
        //language=OracleSqlPlus
        String sql = "SELECT * FROM QUESTIONS_TABLE WHERE categoryId = ? ";

        List<Questions> questionsList = getJdbcTemplate().query(sql, new Object[]{category}, new QuestionMapper());

        return questionsList;
    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
