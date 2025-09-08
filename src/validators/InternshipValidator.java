/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validators;

import domain.Internship;

/**
 *
 * @author kotar
 */
public class InternshipValidator implements AbstractValidator {

    @Override
    public void checkElementaryContraints(Object object) throws Exception {
        if (object == null) {
            throw new Exception("Objekat ne sme biti null.");
        }
        if (!(object instanceof Internship)) {
            throw new Exception("Objekat nije instanca klase Internship.");
        }
        Internship internship = (Internship) object;
        if (internship.getStartDate() == null) {
            throw new Exception("Datum početka stručne prakse mora biti unet.");
        }
        if (internship.getEndDate() == null) {
            throw new Exception("Datum završetka stručne prakse mora biti unet.");
        }
        if (internship.getDefenseDate() == null) {
            throw new Exception("Datum odbrane stručne prakse mora biti unet.");
        }
        if (internship.getGrade() == null) {
            throw new Exception("Ocena na odbrani stručne prakse mora biti uneta.");
        }
        if (internship.getTeacher() == null) {
            throw new Exception("Nastavnik kod koga se brani stručna praksa mora biti unet.");
        }
        if (internship.getExamPeriod() == null) {
            throw new Exception("Ispitni rok u kom se brani stručna praksa mora biti unet.");
        }
        if (internship.getReport() == null) {
            throw new Exception("Dnevnik stručne prakse mora biti unet.");
        }
        new ReportValidator().checkElementaryContraints(internship.getReport());
        if (internship.getStudentOfficer() == null) {
            throw new Exception("Službenik studentske službe mora biti unet.");
        }
        if (internship.getCompany() == null) {
            throw new Exception("Kompanija u kojoj je odrađena stručna praksa mora biti uneta.");
        }
        if (internship.getStudent() == null) {
            throw new Exception("Student mora biti unet.");
        }
        if (internship.getStartDate().isEqual(internship.getEndDate()) || internship.getStartDate().isAfter(internship.getEndDate())) {
            throw new Exception("Datum početka mora biti pre datuma završetka stručne prakse.");
        }
        if (internship.getEndDate().isAfter(internship.getDefenseDate())) {
            throw new Exception("Datum završetka mora biti pre datuma odbrane stručne prakse.");
        }
        if (internship.getDefenseDate().isBefore(internship.getExamPeriod().getStartDate())
                || internship.getDefenseDate().isAfter(internship.getExamPeriod().getEndDate())) {
            throw new Exception("Datum odbrane stručne prakse mora biti u ispitnom roku.");
        }
    }

    @Override
    public void checkComplexContraints(Object object) throws Exception {
    }

}
