/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Uros
 */
public class Student implements Serializable, AbstractDO {

    private Long idStudent;
    private String indexNumber;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Integer yearOfStudy;
    private City city;
    private StudyProgram studyProgram;
    private Module module;

    public Student() {
    }

    public Student(Long idStudent, String indexNumber, String firstName, String lastName, LocalDate dateOfBirth, Integer yearOfStudy, City city, StudyProgram studyProgram, Module module) {
        this.idStudent = idStudent;
        this.indexNumber = indexNumber;
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

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
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
        return firstName;
    }

    @Override
    public String getTable() {
        return "student";
    }

    @Override
    public List<AbstractDO> getList(ResultSet resultSet) throws Exception {
        List<AbstractDO> students = new LinkedList<>();
        while (resultSet.next()) {
            Student student = new Student();
            student.setIdStudent(resultSet.getLong(getTable() + ".id_student"));
            student.setIndexNumber(resultSet.getString(getTable() + ".index_number"));
            student.setFirstName(resultSet.getString(getTable() + ".first_name"));
            student.setLastName(resultSet.getString(getTable() + ".last_name"));
            student.setDateOfBirth(LocalDate.parse(resultSet.getString(getTable() + ".date_of_birth")));
            student.setYearOfStudy(resultSet.getInt(getTable() + ".year_of_study"));

            City city = new City();
            city.setIdCity(resultSet.getLong(city.getTable() + ".id_city"));
            city.setName(resultSet.getString(city.getTable() + ".name"));
            Country country = new Country();
            country.setIdCountry(resultSet.getLong(country.getTable() + ".id_country"));
            country.setName(resultSet.getString(country.getTable() + ".name"));
            city.setCountry(country);
            student.setCity(city);

            StudyProgram studyProgram = new StudyProgram();
            studyProgram.setIdStudyProgram(resultSet.getLong(studyProgram.getTable() + ".id_study_program"));
            studyProgram.setName(resultSet.getString(studyProgram.getTable() + ".name"));
            StudyLevel studyLevel = new StudyLevel();
            studyLevel.setIdStudyLevel(resultSet.getLong(studyLevel.getTable() + ".id_study_level"));
            studyLevel.setName(resultSet.getString(studyLevel.getTable() + ".name"));
            studyProgram.setStudyLevel(studyLevel);
            student.setStudyProgram(studyProgram);

            Module module = new Module();
            module.setIdModule(resultSet.getLong(module.getTable() + ".id_module"));
            module.setName(resultSet.getString(module.getTable() + ".name"));
            StudyProgram moduleProgram = new StudyProgram();
            moduleProgram.setIdStudyProgram(resultSet.getLong(moduleProgram.getTable() + ".id_study_program"));
            moduleProgram.setName(resultSet.getString(moduleProgram.getTable() + ".name"));
            StudyLevel levelProgram = new StudyLevel();
            levelProgram.setIdStudyLevel(resultSet.getLong(levelProgram.getTable() + ".id_study_level"));
            levelProgram.setName(resultSet.getString(levelProgram.getTable() + ".name"));
            moduleProgram.setStudyLevel(levelProgram);
            module.setStudyProgram(moduleProgram);
            student.setModule(module);
            
            students.add(student);
        }
        return students;
    }

    @Override
    public String getPrimaryKey() {
        return getTable() + ".id_student = " + idStudent;
    }

    @Override
    public String getInsertParameters() {
        return "?, ?, ?, ?, ?, ?, ?, ?";
    }

    @Override
    public String getUpdateParameters() {
        return "index_number = ?, first_name = ?, last_name = ?, date_of_birth = ?, year_of_study = ?, id_city = ?, id_study_program = ?, id_module = ?";
    }

    @Override
    public void prepareStatement(PreparedStatement preparedStatement) throws Exception {
        preparedStatement.setString(1, indexNumber);
        preparedStatement.setString(2, firstName);
        preparedStatement.setString(3, lastName);
        preparedStatement.setString(4, dateOfBirth.toString());
        preparedStatement.setInt(5, yearOfStudy);
        preparedStatement.setLong(6, city.getIdCity());
        preparedStatement.setLong(7, studyProgram.getIdStudyProgram());
        preparedStatement.setLong(8, module.getIdModule());
    }

    @Override
    public String getInsertColumns() {
        return "index_number, first_name, last_name, date_of_birth, year_of_study, id_city, id_study_program, id_module";
    }

}
