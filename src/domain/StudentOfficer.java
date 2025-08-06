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
public class StudentOfficer implements Serializable, AbstractDomainObject {

    private Long idStudentOfficer;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private StudyLevel studyLevel;

    public StudentOfficer() {
    }

    public StudentOfficer(Long idStudentOfficer, String firstName, String lastName, String email, String password, StudyLevel studyLevel) {
        this.idStudentOfficer = idStudentOfficer;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.studyLevel = studyLevel;
    }

    public Long getIdStudentOfficer() {
        return idStudentOfficer;
    }

    public void setIdStudentOfficer(Long idStudentOfficer) {
        this.idStudentOfficer = idStudentOfficer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public StudyLevel getStudyLevel() {
        return studyLevel;
    }

    public void setStudyLevel(StudyLevel studyLevel) {
        this.studyLevel = studyLevel;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public String getTable() {
        return "student_officer";
    }

    @Override
    public List<AbstractDomainObject> getList(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getInsertColumns() {
        return "first_name, last_name, email, password, id_study_level";
    }

    @Override
    public String getInsertValues() {
        return "'" + firstName + "', '" + lastName + "', '" + email + "', '" + password + "', " + studyLevel.getIdStudyLevel();
    }

    @Override
    public String getPrimaryKey() {
        return getTable() + ".id_student_officer = " + idStudentOfficer;
    }

    @Override
    public AbstractDomainObject getObject(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateValues() {
        return "first_name = '" + firstName + "', last_name = '" + lastName + "', email = '" + email + "', password = '" + password + "', id_study_level = " + studyLevel.getIdStudyLevel();
    }

}
