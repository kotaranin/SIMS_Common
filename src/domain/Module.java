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
public class Module implements Serializable, AbstractDomainObject {

    private Long idModule;
    private String name;
    private StudyProgram studyProgram;

    public Module() {
    }

    public Module(Long idModule, String name, StudyProgram studyProgram) {
        this.idModule = idModule;
        this.name = name;
        this.studyProgram = studyProgram;
    }

    public Long getIdModule() {
        return idModule;
    }

    public void setIdModule(Long idModule) {
        this.idModule = idModule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudyProgram getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(StudyProgram studyProgram) {
        this.studyProgram = studyProgram;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getTable() {
        return "module";
    }

    @Override
    public List<AbstractDomainObject> getList(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getInsertColumns() {
        return "name, id_study_program";
    }

    @Override
    public String getInsertValues() {
        return "'" + name + "', " + studyProgram.getIdStudyProgram();
    }

    @Override
    public String getPrimaryKey() {
        return getTable() + ".id_module = " + idModule;
    }

    @Override
    public AbstractDomainObject getObject(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateValues() {
        return "name = '" + name + "', id_study_program = " + studyProgram.getIdStudyProgram();
    }

}
