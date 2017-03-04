package com.sumeeth.webapp.data.mapper;

import com.sumeeth.webapp.data.dto.Answer;
import com.sumeeth.webapp.data.dto.Option;
import com.sumeeth.webapp.data.dto.Question;
import com.sumeeth.webapp.data.dto.QuestionCategory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import static com.sumeeth.webapp.util.QuestionUtil.OPTION_KEY;
import static com.sumeeth.webapp.util.QuestionUtil.getFormattedOption;

/**
 * Created by daljit on 29-Jan-17.
 */
public class QuestionMapper implements RowMapper<Question> {
    @Override
    public Question mapRow(ResultSet resultSet, int i) throws SQLException {
        Question qt = new Question();
        Map<String, Object> optionWithAnwer = getFormattedOption(resultSet.getString("options"));
        Option option = (Option) optionWithAnwer.get(OPTION_KEY);
        qt.setId(resultSet.getInt("id"));
/*
        qt.setCreationDate(resultSet.getDate("creation_date"));
        qt.setModifiedDate(resultSet.getDate("modified_date"));
        qt.setActive(resultSet.getInt("is_active"));
        qt.setLatestVersion(resultSet.getInt("is_latest_version"));
*/
        qt.setQuestion(resultSet.getString("question"));
        qt.setOptions(option);
        qt.setAnswer(getAnswer(resultSet));
        qt.setCategory(getQuestionCategory(resultSet));
        qt.setComments(resultSet.getString("comments"));
        qt.setLevel(resultSet.getInt("qlevel"));
        return qt;
    }

    private QuestionCategory getQuestionCategory(ResultSet resultSet) throws SQLException {
        QuestionCategory qc = new QuestionCategory();
        qc.setDescription(resultSet.getString("CATEGORY_DESCRIPTION"));
        qc.setName(resultSet.getString("CATEGORY_NAME"));
        return qc;

    }

    private Answer getAnswer(ResultSet resultSet) throws SQLException {
        Answer answer = new Answer();
        answer.setKey(resultSet.getString("ANSWER_KEY"));
        answer.setDescription(resultSet.getString("ANSWER_DESC"));
        return answer;
    }
}
