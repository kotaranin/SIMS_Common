/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Uros
 */
public class StudyProgram implements Serializable, AbstractDomainObject {

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
    public List<AbstractDomainObject> getList(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getInsertColumns() {
        return "name, id_study_level";
    }

    @Override
    public String getInsertValues() {
        return "'" + name + "', " + studyLevel;
    }

    @Override
    public String getPrimaryKey() {
        return getTable() + ".id_study_program = " + idStudyProgram;
    }

    @Override
    public AbstractDomainObject getObject(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateValues() {
        return "name = '" + name + "', id_study_level = " + studyLevel.getIdStudyLevel();
    }

}
