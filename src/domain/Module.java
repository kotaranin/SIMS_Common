/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Uros
 */
public class Module implements Serializable, AbstractDO {

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
    public List<AbstractDO> getList(ResultSet resultSet) throws Exception {
        List<AbstractDO> modules = new LinkedList<>();
        while (resultSet.next()) {
            Module module = new Module();
            module.setIdModule(resultSet.getLong(getTable() + ".id_module"));
            module.setName(resultSet.getString(getTable() + ".name"));
            StudyProgram studyProgram = new StudyProgram();
            studyProgram.setIdStudyProgram(resultSet.getLong(studyProgram.getTable() + ".id_study_program"));
            studyProgram.setName(resultSet.getString(studyProgram.getTable() + ".name"));
            StudyLevel studyLevel = new StudyLevel();
            studyLevel.setIdStudyLevel(resultSet.getLong(studyLevel.getTable() + ".id_study_level"));
            studyLevel.setName(resultSet.getString(studyLevel.getTable() + ".name"));
            studyProgram.setStudyLevel(studyLevel);
            module.setStudyProgram(studyProgram);
            modules.add(module);
        }
        return modules;
    }

    @Override
    public String getPrimaryKey() {
        return getTable() + ".id_module = " + idModule;
    }

    @Override
    public String getInsertParameters() {
        return "?, ?";
    }

    @Override
    public String getUpdateParameters() {
        return "name = ?, id_study_program = ?";
    }

    @Override
    public void prepareStatement(PreparedStatement preparedStatement) throws Exception {
        preparedStatement.setString(1, name);
        preparedStatement.setLong(2, studyProgram.getIdStudyProgram());
    }

    @Override
    public String getInsertColumns() {
        return "name, id_study_program";
    }

}
