package com.threeconnectors;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaperDAO {
    public List<Paper> getPapersByProfessorId(int professorId) throws SQLException {
        List<Paper> papers = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM papers WHERE professor_id = ?");
        statement.setInt(1, professorId);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Paper paper = new Paper();
            paper.setId(resultSet.getInt("id"));
            paper.setTitle(resultSet.getString("title"));
            paper.setDate(resultSet.getDate("date"));
            paper.setProfessorId(resultSet.getInt("professor_id"));
            papers.add(paper);
        }

        return papers;
    }
}
