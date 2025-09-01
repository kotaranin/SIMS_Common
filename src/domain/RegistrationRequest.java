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
    private String password;
    private boolean admin;
    private StudyLevel studyLevel;

    public RegistrationRequest() {
    }

    public RegistrationRequest(Long idRegistrationRequest, String firstName, String lastName, String email, String password, boolean admin, StudyLevel studyLevel) {
        this.idRegistrationRequest = idRegistrationRequest;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return firstName;
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
            registrationRequest.setPassword(resultSet.getString(getTable() + ".password"));
            registrationRequest.setAdmin(resultSet.getBoolean(getTable() + ".admin"));
            StudyLevel studyLevel = new StudyLevel();
            studyLevel.setIdStudyLevel(resultSet.getLong(studyLevel.getTable() + ".id_study_level"));
            studyLevel.setName(resultSet.getString(studyLevel.getTable() + ".name"));
            registrationRequest.setStudyLevel(studyLevel);
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
        return "first_name, last_name, email, password, admin, id_study_level";
    }

    @Override
    public String getInsertParameters() {
        return "?, ?, ?, ?, ?, ?";
    }

    @Override
    public String getUpdateParameters() {
        return "first_name = ?, last_name = ?, email = ?, password = ?, admin = ?, id_study_level = ?";
    }

    @Override
    public void prepareStatement(PreparedStatement preparedStatement) throws Exception {
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, password);
        preparedStatement.setBoolean(5, admin);
        preparedStatement.setLong(6, studyLevel.getIdStudyLevel());
    }
}
