/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import enums.Grade;
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
public class Internship implements Serializable, AbstractDO {

    private Long idInternship;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate defenseDate;
    private Grade grade;
    private Teacher teacher;
    private ExamPeriod examPeriod;
    private Report report;
    private StudentOfficer studentOfficer;
    private Company company;
    private Student student;

    public Internship() {
    }

    public Internship(Long idInternship, LocalDate startDate, LocalDate endDate, LocalDate defenseDate, Grade grade, Teacher teacher, ExamPeriod examPeriod, Report report, StudentOfficer studentOfficer, Company company, Student student) {
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

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
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
    public List<AbstractDO> getList(ResultSet resultSet) throws Exception {
        List<AbstractDO> internships = new LinkedList<>();
        while (resultSet.next()) {
            Internship internship = new Internship();
            internship.setIdInternship(resultSet.getLong(getTable() + ".id_internship"));
            internship.setStartDate(LocalDate.parse(resultSet.getString(getTable() + ".start_date")));
            internship.setEndDate(LocalDate.parse(resultSet.getString(getTable() + ".end_date")));
            internship.setDefenseDate(LocalDate.parse(resultSet.getString(getTable() + ".defense_date")));
            internship.setGrade(Grade.valueOf(resultSet.getString(getTable() + ".grade")));

            Teacher teacher = new Teacher();
            teacher.setIdTeacher(resultSet.getLong(teacher.getTable() + ".id_teacher"));
            teacher.setFirstName(resultSet.getString(teacher.getTable() + ".first_name"));
            teacher.setLastName(resultSet.getString(teacher.getTable() + ".last_name"));
            internship.setTeacher(teacher);

            ExamPeriod examPeriod = new ExamPeriod();
            examPeriod.setIdExamPeriod(resultSet.getLong(examPeriod.getTable() + ".id_exam_period"));
            examPeriod.setName(resultSet.getString(examPeriod.getTable() + ".name"));
            examPeriod.setStartDate(LocalDate.parse(resultSet.getString(examPeriod.getTable() + ".start_date")));
            examPeriod.setEndDate(LocalDate.parse(resultSet.getString(examPeriod.getTable() + ".end_date")));
            internship.setExamPeriod(examPeriod);

            Report report = new Report();
            report.setIdReport(resultSet.getLong(report.getTable() + ".id_report"));
            report.setFileName(resultSet.getString(report.getTable() + ".file_name"));
            report.setFileContent(resultSet.getBytes(report.getTable() + ".file_content"));
            internship.setReport(report);

            StudentOfficer studentOfficer = new StudentOfficer();
            studentOfficer.setIdStudentOfficer(resultSet.getLong(studentOfficer.getTable() + ".id_student_officer"));
            studentOfficer.setFirstName(resultSet.getString(studentOfficer.getTable() + ".first_name"));
            studentOfficer.setLastName(resultSet.getString(studentOfficer.getTable() + ".last_name"));
            studentOfficer.setEmail(resultSet.getString(studentOfficer.getTable() + ".email"));
            internship.setStudentOfficer(studentOfficer);

            Company company = new Company();
            company.setIdCompany(resultSet.getLong(company.getTable() + ".id_company"));
            company.setName(resultSet.getString(company.getTable() + ".name"));
            company.setAddress(resultSet.getString(company.getTable() + ".address"));
            internship.setCompany(company);

            Student student = new Student();
            student.setIdStudent(resultSet.getLong(student.getTable() + ".id_student"));
            student.setIndexNumber(resultSet.getString(student.getTable() + ".index_number"));
            student.setFirstName(resultSet.getString(student.getTable() + ".first_name"));
            student.setLastName(resultSet.getString(student.getTable() + ".last_name"));
            student.setDateOfBirth(LocalDate.parse(resultSet.getString(student.getTable() + ".date_of_birth")));
            student.setYearOfStudy(resultSet.getInt(student.getTable() + ".year_of_study"));
            internship.setStudent(student);

            internships.add(internship);
        }
        return internships;
    }

    @Override
    public String getPrimaryKey() {
        return getTable() + ".id_internship = " + idInternship;
    }

    @Override
    public String getInsertParameters() {
        return "?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
    }

    @Override
    public String getUpdateParameters() {
        return "start_date = ?, end_date = ?, defense_date = ?, grade = ?, id_teacher = ?, id_exam_period = ?, id_report = ?, id_student_officer = ?, id_company = ?, id_student = ?";
    }

    @Override
    public void prepareStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, startDate.toString());
        preparedStatement.setString(2, endDate.toString());
        preparedStatement.setString(3, defenseDate.toString());
        preparedStatement.setString(4, grade.toString());
        preparedStatement.setLong(5, teacher.getIdTeacher());
        preparedStatement.setLong(6, examPeriod.getIdExamPeriod());
        preparedStatement.setLong(7, report.getIdReport());
        preparedStatement.setLong(8, studentOfficer.getIdStudentOfficer());
        preparedStatement.setLong(9, company.getIdCompany());
        preparedStatement.setLong(10, student.getIdStudent());
    }

    @Override
    public String getInsertColumns() {
        return "start_date, end_date, defense_date, grade, id_teacher, id_exam_period, id_report, id_student_officer, id_company, id_student";
    }

}
