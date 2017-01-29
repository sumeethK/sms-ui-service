package com.sumeeth.webapp.data.mapper;

import com.sumeeth.webapp.data.dto.Questions;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.sumeeth.webapp.util.QuestionUtil.getFormattedOption;

/**
 * Created by daljit on 29-Jan-17.
 */
public class QuestionMapper implements RowMapper<Questions> {
    @Override
    public Questions mapRow(ResultSet resultSet, int i) throws SQLException {
        Questions qt = new Questions();
        qt.setId(resultSet.getInt("id"));
        qt.setCreationDate(resultSet.getDate("creation_date"));
        qt.setModifiedDate(resultSet.getDate("modified_date"));
        qt.setActive(resultSet.getInt("is_active"));
        qt.setLatestVersion(resultSet.getInt("is_latest_version"));
        qt.setQuestion(resultSet.getString("question"));
        qt.setOptions(getFormattedOption(resultSet.getString("options")));
        qt.setComments(resultSet.getString("comments"));
        qt.setLevel(resultSet.getInt("qlevel"));
        return qt;
    }
}
