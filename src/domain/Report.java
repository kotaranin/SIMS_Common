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
public class Report implements Serializable, AbstractDomainObject {

    private Long idReport;
    private String fileName;
    private String filePath;

    public Report() {
    }

    public Report(Long idReport, String fileName, String filePath) {
        this.idReport = idReport;
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public Long getIdReport() {
        return idReport;
    }

    public void setIdReport(Long idReport) {
        this.idReport = idReport;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return fileName;
    }

    @Override
    public String getTable() {
        return "report";
    }

    @Override
    public List<AbstractDomainObject> getList(ResultSet resultSet) throws Exception {
        List<AbstractDomainObject> reports = new LinkedList<>();
        while (resultSet.next()) {
            Report report = new Report();
            report.setIdReport(resultSet.getLong(getTable() + ".id_report"));
            report.setFileName(resultSet.getString(getTable() + ".file_name"));
            report.setFilePath(resultSet.getString(getTable() + ".file_path"));
            reports.add(report);
        }
        return reports;
    }

    @Override
    public String getInsertColumns() {
        return "file_name, file_path";
    }

    @Override
    public String getInsertValues() {
        return "'" + fileName + "', '" + filePath + "'";
    }

    @Override
    public String getPrimaryKey() {
        return getTable() + ".id_report = " + idReport;
    }

    @Override
    public AbstractDomainObject getObject(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateValues() {
        return "file_name = '" + fileName + "', file_path = '" + filePath + "'";
    }

}
