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

/**
 *
 * @author Uros
 */
public class StudyProgram implements Serializable, AbstractDO {

    private Long idStudyProgram;
    private String name;
    private StudyLevel studyLevel;

    public StudyProgram() {
    }

    public StudyProgram(Long idStudyProgram, String name, StudyLevel studyLevel) {
        this.idStudyProgram = idStudyProgram;
        this.name = name;
        this.studyLevel = studyLevel;
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
            StudyLevel studyLevel = new StudyLevel();
            studyLevel.setIdStudyLevel(resultSet.getLong(studyLevel.getTable() + ".id_study_level"));
            studyLevel.setName(resultSet.getString(studyLevel.getTable() + ".name"));
            studyProgram.setStudyLevel(studyLevel);
            studyPrograms.add(studyProgram);
        }
        return studyPrograms;
    }

    @Override
    public String getPrimaryKey() {
        return getTable() + ".id_study_program = " + idStudyProgram;
    }

    @Override
    public AbstractDO getObject(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public void prepareInsertStatement(PreparedStatement preparedStatement) throws Exception {
        preparedStatement.setString(1, "name");
        preparedStatement.setString(2, "id_study_level");
        preparedStatement.setString(3, name);
        preparedStatement.setLong(4, studyLevel.getIdStudyLevel());
    }

    @Override
    public void prepareUpdateStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, name);
        preparedStatement.setLong(2, studyLevel.getIdStudyLevel());
    }

}
