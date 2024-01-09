package com.threeconnectors;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {
    public List<Professor> getAllProfessors() throws SQLException {
        List<Professor> professors = new ArrayList<>();
        Connection connection = JDBCConnector.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM professors");


        while (resultSet.next()) {
            Professor professor = new Professor();
            professor.setId(resultSet.getInt("id"));
            professor.setName(resultSet.getString("name"));
            professor.setEmail(resultSet.getString("email"));
            professors.add(professor);
        }

        return professors;
    }


}
