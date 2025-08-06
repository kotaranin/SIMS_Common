/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Uros
 */
public class Teacher implements Serializable, AbstractDomainObject {

    private Long idTeacher;
    private String firstName;
    private String lastName;

    public Teacher() {
    }

    public Teacher(Long idTeacher, String firstName, String lastName) {
        this.idTeacher = idTeacher;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Long idTeacher) {
        this.idTeacher = idTeacher;
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

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public String getTable() {
        return "teacher";
    }

    @Override
    public List<AbstractDomainObject> getList(ResultSet resultSet) throws Exception {
        List<AbstractDomainObject> teachers = new LinkedList<>();
        while (resultSet.next()) {
            Teacher teacher = new Teacher();
            teacher.setIdTeacher(resultSet.getLong(getTable() + ".id_teacher"));
            teacher.setFirstName(resultSet.getString(getTable() + ".first_name"));
            teacher.setLastName(resultSet.getString(getTable() + ".last_name"));
            teachers.add(teacher);
        }
        return teachers;
    }

    @Override
    public String getInsertColumns() {
        return "first_name, last_name";
    }

    @Override
    public String getInsertValues() {
        return "'" + firstName + "', '" + lastName + "'";
    }

    @Override
    public String getPrimaryKey() {
        return getTable() + ".id_teacher = " + idTeacher;
    }

    @Override
    public AbstractDomainObject getObject(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateValues() {
        return "first_name = '" + firstName + "', last_name = '" + lastName + "'";
    }

}
