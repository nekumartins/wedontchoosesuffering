package com.threeconnectors;

import java.sql.SQLException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException, SQLException {
        ProfessorService professorService = new ProfessorService();
        List<Professor> professors = professorService.getAllProfessorsAndTheirPapers();

        for (Professor professor : professors) {
            System.out.println(professor.getName() + " has published " + professor.getPapers().size() + " papers.");
        }
    }
}