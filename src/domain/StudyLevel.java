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
public class StudyLevel implements Serializable, AbstractDO {

    private Long idStudyLevel;
    private String name;

    public StudyLevel() {
    }

    public StudyLevel(Long idStudyLevel, String name) {
        this.idStudyLevel = idStudyLevel;
        this.name = name;
    }

    public Long getIdStudyLevel() {
        return idStudyLevel;
    }

    public void setIdStudyLevel(Long idStudyLevel) {
        this.idStudyLevel = idStudyLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getTable() {
        return "study_level";
    }

    @Override
    public List<AbstractDO> getList(ResultSet resultSet) throws Exception {
        List<AbstractDO> studyLevels = new LinkedList<>();
        while (resultSet.next()) {
            StudyLevel studyLevel = new StudyLevel();
            studyLevel.setIdStudyLevel(resultSet.getLong(getTable() + ".id_study_level"));
            studyLevel.setName(resultSet.getString(getTable() + ".name"));
            studyLevels.add(studyLevel);
        }
        return studyLevels;
    }

    @Override
    public String getPrimaryKey() {
        return getTable() + ".id_study_level = " + idStudyLevel;
    }

    @Override
    public AbstractDO getObject(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getInsertParameters() {
        return "?";
    }

    @Override
    public String getUpdateParameters() {
        return "name = ?";
    }

    @Override
    public void prepareStatement(PreparedStatement preparedStatement) throws Exception {
        preparedStatement.setString(1, name);
    }

    @Override
    public String getInsertColumns() {
        return "name";
    }

}
