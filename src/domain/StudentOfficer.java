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
    private String passwordSalt;
    private String hashedPassword;
    private String question;
    private String answerSalt;
    private String hashedAnswer;
    private Boolean admin;
    private StudyLevel studyLevel;

    public StudentOfficer() {
    }

    public StudentOfficer(Long idStudentOfficer, String firstName, String lastName, String email, String passwordSalt, String hashedPassword, String question, String answerSalt, String hashedAnswer, Boolean admin, StudyLevel studyLevel) {
        this.idStudentOfficer = idStudentOfficer;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordSalt = passwordSalt;
        this.hashedPassword = hashedPassword;
        this.question = question;
        this.answerSalt = answerSalt;
        this.hashedAnswer = hashedAnswer;
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

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerSalt() {
        return answerSalt;
    }

    public void setAnswerSalt(String answerSalt) {
        this.answerSalt = answerSalt;
    }

    public String getHashedAnswer() {
        return hashedAnswer;
    }

    public void setHashedAnswer(String hashedAnswer) {
        this.hashedAnswer = hashedAnswer;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
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
        hash = 71 * hash + Objects.hashCode(this.hashedPassword);
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
        return Objects.equals(this.hashedPassword, other.hashedPassword);
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
            studentOfficer.setPasswordSalt(resultSet.getString(getTable() + ".password_salt"));
            studentOfficer.setHashedPassword(resultSet.getString(getTable() + ".hashed_password"));
            studentOfficer.setQuestion(resultSet.getString(getTable() + ".question"));
            studentOfficer.setAnswerSalt(resultSet.getString(getTable() + ".answer_salt"));
            studentOfficer.setHashedAnswer(resultSet.getString(getTable() + ".hashed_answer"));
            studentOfficer.setAdmin(resultSet.getBoolean(getTable() + ".admin"));
            
            StudyLevel sl = new StudyLevel();
            sl.setIdStudyLevel(resultSet.getLong(sl.getTable() + ".id_study_level"));
            sl.setName(resultSet.getString(sl.getTable() + ".name"));
            studentOfficer.setStudyLevel(sl);
            
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
        return "?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
    }

    @Override
    public String getUpdateParameters() {
        return "first_name = ?, last_name = ?, email = ?, password_salt = ?, hashed_password = ?, question = ?, answer_salt = ?, hashed_answer = ?, admin = ?, id_study_level = ?";
    }

    @Override
    public void prepareStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, passwordSalt);
        preparedStatement.setString(5, hashedPassword);
        preparedStatement.setString(6, question);
        preparedStatement.setString(7, answerSalt);
        preparedStatement.setString(8, hashedAnswer);
        preparedStatement.setBoolean(9, admin);
        preparedStatement.setLong(10, studyLevel.getIdStudyLevel());
    }

    @Override
    public String getInsertColumns() {
        return "first_name, last_name, email, password_salt, hashed_password, question, answer_salt, hashed_answer, admin, id_study_level";
    }

}
