/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Uros
 */
public class StudyProgram implements Serializable, AbstractDO {

    private Long idStudyProgram;
    private String name;
    private StudyLevel studyLevel;
    private List<domain.Module> modules;

    public StudyProgram() {
    }

    public StudyProgram(Long idStudyProgram, String name, StudyLevel studyLevel, List<Module> modules) {
        this.idStudyProgram = idStudyProgram;
        this.name = name;
        this.studyLevel = studyLevel;
        this.modules = modules;
    }

    public Long getIdStudyProgram() {
        return idStudyProgram;
    }

    public void setIdStudyProgram(Long idStudyProgram) {
        this.idStudyProgram = idStudyProgram;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudyLevel getStudyLevel() {
        return studyLevel;
    }

    public void setStudyLevel(StudyLevel studyLevel) {
        this.studyLevel = studyLevel;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.idStudyProgram);
        hash = 83 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StudyProgram other = (StudyProgram) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.idStudyProgram, other.idStudyProgram);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getTable() {
        return "study_program";
    }

    @Override
    public List<AbstractDO> getList(ResultSet resultSet) throws Exception {
        List<AbstractDO> studyPrograms = new LinkedList<>();
        while (resultSet.next()) {
            StudyProgram studyProgram = new StudyProgram();
            studyProgram.setIdStudyProgram(resultSet.getLong(getTable() + ".id_study_program"));
            studyProgram.setName(resultSet.getString(getTable() + ".name"));
            StudyLevel sl = new StudyLevel();
            sl.setIdStudyLevel(resultSet.getLong(sl.getTable() + ".id_study_level"));
            sl.setName(resultSet.getString(sl.getTable() + ".name"));
            studyProgram.setStudyLevel(sl);
            studyPrograms.add(studyProgram);
        }
        return studyPrograms;
    }

    @Override
    public String getPrimaryKey() {
        return getTable() + ".id_study_program = " + idStudyProgram + " AND " + getTable() + ".id_study_level = " + studyLevel.getIdStudyLevel();
    }

    @Override
    public String getInsertParameters() {
        return "?, ?";
    }

    @Override
    public String getUpdateParameters() {
        return "name = ?, id_study_level = ?";
    }

    @Override
    public void prepareStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, name);
        preparedStatement.setLong(2, studyLevel.getIdStudyLevel());
    }

    @Override
    public String getInsertColumns() {
        return "name, id_study_level";
    }

}
