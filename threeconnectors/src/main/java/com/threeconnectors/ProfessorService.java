package com.threeconnectors;

import java.sql.SQLException;
import java.util.List;

public class ProfessorService {
    private ProfessorDAO professorDAO = new ProfessorDAO();
    private PaperDAO paperDAO = new PaperDAO();

    public List<Professor> getAllProfessorsAndTheirPapers() throws SQLException {
        List<Professor> professors = professorDAO.getAllProfessors();

        for (Professor professor : professors) {
            List<Paper> papers = paperDAO.getPapersByProfessorId(professor.getId());
            professor.setPapers(papers);
        }

        return professors;
    }
}