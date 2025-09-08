/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Uros
 */
public class Report implements Serializable, AbstractDO {

    private Long idReport;
    private String fileName;
    private byte[] fileContent;

    public Report() {
    }

    public Report(Long idReport, String fileName, byte[] fileContent) {
        this.idReport = idReport;
        this.fileName = fileName;
        this.fileContent = fileContent;
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

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
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
    public List<AbstractDO> getList(ResultSet resultSet) throws Exception {
        List<AbstractDO> reports = new LinkedList<>();
        while (resultSet.next()) {
            Report report = new Report();
            report.setIdReport(resultSet.getLong(getTable() + ".id_report"));
            report.setFileName(resultSet.getString(getTable() + ".file_name"));
            report.setFileContent(resultSet.getBytes(getTable() + ".file_content"));
            reports.add(report);
        }
        return reports;
    }

    @Override
    public String getPrimaryKey() {
        return getTable() + ".id_report = " + idReport;
    }

    @Override
    public String getInsertParameters() {
        return "?, ?";
    }

    @Override
    public String getUpdateParameters() {
        return "file_name = ?, file_content = ?";
    }

    @Override
    public void prepareStatement(PreparedStatement preparedStatement) throws Exception {
        preparedStatement.setString(1, fileName);
        preparedStatement.setBytes(2, fileContent);
    }

    @Override
    public String getInsertColumns() {
        return "file_name, file_content";
    }
}
