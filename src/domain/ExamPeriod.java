/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Uros
 */
public class ExamPeriod implements Serializable, AbstractDO {

    private Long idExamPeriod;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    public ExamPeriod() {
    }

    public ExamPeriod(Long idExamPeriod, String name, LocalDate startDate, LocalDate endDate) {
        this.idExamPeriod = idExamPeriod;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getIdExamPeriod() {
        return idExamPeriod;
    }

    public void setIdExamPeriod(Long idExamPeriod) {
        this.idExamPeriod = idExamPeriod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getTable() {
        return "exam_period";
    }

    @Override
    public List<AbstractDO> getList(ResultSet resultSet) throws Exception {
        List<AbstractDO> examPeriods = new LinkedList<>();
        while (resultSet.next()) {
            ExamPeriod examPeriod = new ExamPeriod();
            examPeriod.setIdExamPeriod(resultSet.getLong(getTable() + ".id_exam_period"));
            examPeriod.setStartDate(LocalDate.parse(resultSet.getString(getTable() + ".start_date")));
            examPeriod.setEndDate(LocalDate.parse(resultSet.getString(getTable() + ".end_date")));
            examPeriods.add(examPeriod);
        }
        return examPeriods;
    }

    @Override
    public String getPrimaryKey() {
        return getTable() + ".id_exam_period = " + idExamPeriod;
    }

    @Override
    public AbstractDO getObject(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getInsertParameters() {
        return "?, ?, ?";
    }

    @Override
    public String getUpdateParameters() {
        return "name = ?, start_date = ?, end_date = ?";
    }

    @Override
    public void prepareInsertStatement(PreparedStatement preparedStatement) throws Exception {
        preparedStatement.setString(1, "name");
        preparedStatement.setString(2, "start_date");
        preparedStatement.setString(3, "end_date");
        preparedStatement.setString(4, name);
        preparedStatement.setString(5, startDate.toString());
        preparedStatement.setString(6, endDate.toString());
    }

    @Override
    public void prepareUpdateStatement(PreparedStatement preparedStatement) throws Exception {
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, startDate.toString());
        preparedStatement.setString(3, endDate.toString());
    }

}
