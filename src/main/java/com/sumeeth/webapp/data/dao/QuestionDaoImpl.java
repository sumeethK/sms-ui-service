package com.sumeeth.webapp.data.dao;

import com.sumeeth.webapp.data.dto.Question;
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
    public List<Question> getAllQuestions() {

        //language=OracleSqlPlus
        String sql = "SELECT qt.ID,qt.QUESTION,qt.OPTIONS,qt.QLEVEL,qt.COMMENTS," +
                "qc.CATEGORY_NAME,qc .CATEGORY_DESCRIPTION,\n" +
                "  at.ANSWER_KEY,at.ANSWER_DESC\n" +
                "FROM QUESTIONS_TABLE qt JOIN\n" +
                "  QUESTION_CATEGORY qc ON qt.CATEGORYID = qc.ID JOIN\n" +
                "  ANSWER_TABLE at ON qt.ANSWER_ID = at.OID_ANSWER\n" +
                "WHERE qt.IS_ACTIVE=1 AND qt.IS_LATEST_VERSION=1\n" +
                "AND qc.IS_ACTIVE=1 AND qc.IS_LATEST_VERSION=1\n" +
                "AND  at.IS_ACTIVE=1 AND at.IS_LATEST_VERSION=1\n";

        return getJdbcTemplate().query(sql, new QuestionMapper());
    }

    @Override
    public List<Question> getAllQuestoinsByCategory(int category) {
        //language=OracleSqlPlus
        String sql = "SELECT * FROM QUESTIONS_TABLE WHERE categoryId = ? ";

        List<Question> questionsList = getJdbcTemplate().query(sql, new Object[]{category}, new QuestionMapper());

        return questionsList;
    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
