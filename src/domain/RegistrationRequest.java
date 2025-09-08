/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author kotar
 */
public class RegistrationRequest implements AbstractDO {

    private Long idRegistrationRequest;
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

    public RegistrationRequest() {
    }

    public RegistrationRequest(Long idRegistrationRequest, String firstName, String lastName, String email, String passwordSalt, String hashedPassword, String question, String answerSalt, String hashedAnswer, Boolean admin, StudyLevel studyLevel) {
        this.idRegistrationRequest = idRegistrationRequest;
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

    public Long getIdRegistrationRequest() {
        return idRegistrationRequest;
    }

    public void setIdRegistrationRequest(Long idRegistrationRequest) {
        this.idRegistrationRequest = idRegistrationRequest;
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
    public String getTable() {
        return "registration_request";
    }

    @Override
    public List<AbstractDO> getList(ResultSet resultSet) throws Exception {
        List<AbstractDO> registrationRequests = new LinkedList<>();
        while (resultSet.next()) {
            RegistrationRequest registrationRequest = new RegistrationRequest();
            registrationRequest.setIdRegistrationRequest(resultSet.getLong(getTable() + ".id_registration_request"));
            registrationRequest.setFirstName(resultSet.getString(getTable() + ".first_name"));
            registrationRequest.setLastName(resultSet.getString(getTable() + ".last_name"));
            registrationRequest.setEmail(resultSet.getString(getTable() + ".email"));
            registrationRequest.setPasswordSalt(resultSet.getString(getTable() + ".password_salt"));
            registrationRequest.setHashedPassword(resultSet.getString(getTable() + ".hashed_password"));
            registrationRequest.setQuestion(resultSet.getString(getTable() + ".question"));
            registrationRequest.setAnswerSalt(resultSet.getString(getTable() + ".answer_salt"));
            registrationRequest.setHashedAnswer(resultSet.getString(getTable() + ".hashed_answer"));
            registrationRequest.setAdmin(resultSet.getBoolean(getTable() + ".admin"));
            StudyLevel sl = new StudyLevel();
            sl.setIdStudyLevel(resultSet.getLong(sl.getTable() + ".id_study_level"));
            sl.setName(resultSet.getString(sl.getTable() + ".name"));
            registrationRequest.setStudyLevel(sl);
            registrationRequests.add(registrationRequest);
        }
        return registrationRequests;
    }

    @Override
    public String getPrimaryKey() {
        return "id_registration_request = " + idRegistrationRequest;
    }

    @Override
    public String getInsertColumns() {
        return "first_name, last_name, email, password_salt, hashed_password, question, answer_salt, hashed_answer, admin, id_study_level";
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
    public void prepareStatement(PreparedStatement preparedStatement) throws Exception {
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
}
