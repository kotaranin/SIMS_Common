/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Uros
 */
public class Student implements Serializable, AbstractDomainObject {

    private Long idStudent;
    private String index;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Integer yearOfStudy;
    private City city;
    private StudyProgram studyProgram;
    private Module module;

    public Student() {
    }

    public Student(Long idStudent, String index, String firstName, String lastName, LocalDate dateOfBirth, Integer yearOfStudy, City city, StudyProgram studyProgram, Module module) {
        this.idStudent = idStudent;
        this.index = index;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.yearOfStudy = yearOfStudy;
        this.city = city;
        this.studyProgram = studyProgram;
        this.module = module;
    }

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public StudyProgram getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(StudyProgram studyProgram) {
        this.studyProgram = studyProgram;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public String getTable() {
        return "student";
    }

    @Override
    public List<AbstractDomainObject> getList(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getInsertColumns() {
        return "index, first_name, last_name, date_of_birth, year_of_study, id_city, id_study_program, id_module";
    }

    @Override
    public String getInsertValues() {
        return "'" + index + "', '" + firstName + "', '" + lastName + "', '" + dateOfBirth + "', " + yearOfStudy + ", " + city.getIdCity() + ", " + studyProgram.getIdStudyProgram() + ", " + module.getIdModule();
    }

    @Override
    public String getPrimaryKey() {
        return getTable() + ".id_student = " + idStudent;
    }

    @Override
    public AbstractDomainObject getObject(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateValues() {
        return "index = '" + index + "', first_name = '" + firstName + "', last_name = '" + lastName + "', date_of_birth = '" + dateOfBirth + "', year_of_study = " + yearOfStudy + ", id_city = " + city.getIdCity() + ", id_study_program = " + studyProgram.getIdStudyProgram() + ", id_module = " + module.getIdModule();
    }

}
