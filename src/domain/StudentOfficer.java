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
public class StudentOfficer implements Serializable, AbstractDO {

    private Long idStudentOfficer;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String question;
    private String answer;
    private boolean admin;
    private StudyLevel studyLevel;

    public StudentOfficer() {
    }

    public StudentOfficer(Long idStudentOfficer, String firstName, String lastName, String email, String password, String question, String answer, boolean admin, StudyLevel studyLevel) {
        this.idStudentOfficer = idStudentOfficer;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.question = question;
        this.answer = answer;
        this.admin = admin;
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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
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
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.email);
        hash = 71 * hash + Objects.hashCode(this.password);
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
        final StudentOfficer other = (StudentOfficer) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }

    @Override
    public String getTable() {
        return "student_officer";
    }

    @Override
    public List<AbstractDO> getList(ResultSet resultSet) throws Exception {
        List<AbstractDO> studentOfficers = new LinkedList<>();
        while (resultSet.next()) {
            StudentOfficer studentOfficer = new StudentOfficer();
            studentOfficer.setIdStudentOfficer(resultSet.getLong(getTable() + ".id_student_officer"));
            studentOfficer.setFirstName(resultSet.getString(getTable() + ".first_name"));
            studentOfficer.setLastName(resultSet.getString(getTable() + ".last_name"));
            studentOfficer.setEmail(resultSet.getString(getTable() + ".email"));
            studentOfficer.setPassword(resultSet.getString(getTable() + ".password"));
            studentOfficer.setQuestion(resultSet.getString(getTable() + ".question"));
            studentOfficer.setAnswer(resultSet.getString(getTable() + ".answer"));
            studentOfficer.setAdmin(resultSet.getBoolean(getTable() + ".admin"));
            StudyLevel studyLevel = new StudyLevel();
            studyLevel.setIdStudyLevel(resultSet.getLong(studyLevel.getTable() + ".id_study_level"));
            studyLevel.setName(resultSet.getString(studyLevel.getTable() + ".name"));
            studentOfficer.setStudyLevel(studyLevel);
            studentOfficers.add(studentOfficer);
        }
        return studentOfficers;
    }

    @Override
    public String getPrimaryKey() {
        return getTable() + ".id_student_officer = " + idStudentOfficer;
    }

    @Override
    public String getInsertParameters() {
        return "?, ?, ?, ?, ?, ?, ?, ?";
    }

    @Override
    public String getUpdateParameters() {
        return "first_name = ?, last_name = ?, email = ?, password = ?, question = ?, answer = ?, admin = ?, id_study_level = ?";
    }

    @Override
    public void prepareStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, password);
        preparedStatement.setString(5, question);
        preparedStatement.setString(6, answer);
        preparedStatement.setBoolean(7, admin);
        preparedStatement.setLong(8, studyLevel.getIdStudyLevel());
    }

    @Override
    public String getInsertColumns() {
        return "first_name, last_name, email, password, question, answer, admin, id_study_level";
    }

}
