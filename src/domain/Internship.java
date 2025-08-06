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
public class Internship implements Serializable, AbstractDomainObject {

    private Long idInternship;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate defenseDate;
    private Integer grade;
    private Teacher teacher;
    private ExamPeriod examPeriod;
    private Report report;
    private StudentOfficer studentOfficer;
    private Company company;
    private Student student;

    public Internship() {
    }

    public Internship(Long idInternship, LocalDate startDate, LocalDate endDate, LocalDate defenseDate, Integer grade, Teacher teacher, ExamPeriod examPeriod, Report report, StudentOfficer studentOfficer, Company company, Student student) {
        this.idInternship = idInternship;
        this.startDate = startDate;
        this.endDate = endDate;
        this.defenseDate = defenseDate;
        this.grade = grade;
        this.teacher = teacher;
        this.examPeriod = examPeriod;
        this.report = report;
        this.studentOfficer = studentOfficer;
        this.company = company;
        this.student = student;
    }

    public Long getIdInternship() {
        return idInternship;
    }

    public void setIdInternship(Long idInternship) {
        this.idInternship = idInternship;
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

    public LocalDate getDefenseDate() {
        return defenseDate;
    }

    public void setDefenseDate(LocalDate defenseDate) {
        this.defenseDate = defenseDate;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ExamPeriod getExamPeriod() {
        return examPeriod;
    }

    public void setExamPeriod(ExamPeriod examPeriod) {
        this.examPeriod = examPeriod;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public StudentOfficer getStudentOfficer() {
        return studentOfficer;
    }

    public void setStudentOfficer(StudentOfficer studentOfficer) {
        this.studentOfficer = studentOfficer;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return student.toString();
    }

    @Override
    public String getTable() {
        return "internship";
    }

    @Override
    public List<AbstractDomainObject> getList(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getInsertColumns() {
        return "start_date, end_date, defense_date, grade, id_teacher, id_exam_period, id_report, id_student_officer, id_company, id_student";
    }

    @Override
    public String getInsertValues() {
        return "'" + startDate + "', '" + endDate + "', '" + defenseDate + "', " + grade + ", " + teacher.getIdTeacher() + ", " + examPeriod.getIdExamPeriod() + ", " + report.getIdReport() + ", " + studentOfficer.getIdStudentOfficer() + ", " + company.getIdCompany() + ", " + student.getIdStudent();
    }

    @Override
    public String getPrimaryKey() {
        return getTable() + ".id_internship = " + idInternship;
    }

    @Override
    public AbstractDomainObject getObject(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateValues() {
        return "start_date = '" + startDate + "', end_date = '" + endDate + "', defense_date = '" + defenseDate + "', grade = " + grade + ", id_teacher = " + teacher.getIdTeacher() + ", id_exam_period = " + examPeriod.getIdExamPeriod() + ", id_report = " + report.getIdReport() + ", id_student_officer = " + studentOfficer.getIdStudentOfficer() + ", id_company = " + company.getIdCompany() + ", id_student = " + student.getIdStudent();
    }

}
