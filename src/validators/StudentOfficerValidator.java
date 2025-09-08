/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validators;

import domain.StudentOfficer;

/**
 *
 * @author kotar
 */
public class StudentOfficerValidator implements AbstractValidator {

    @Override
    public void checkElementaryContraints(Object object) throws Exception {
        if (object == null) {
            throw new Exception("Objekat ne sme biti null.");
        }
        if (!(object instanceof StudentOfficer)) {
            throw new Exception("Objekat nije instanca klase StudentOfficer.");
        }
        StudentOfficer studentOfficer = (StudentOfficer) object;
        if (studentOfficer.getFirstName() == null || studentOfficer.getFirstName().isEmpty() || studentOfficer.getFirstName().isBlank()) {
            throw new Exception("Ime službenika mora biti uneto.");
        }
        if (studentOfficer.getLastName() == null || studentOfficer.getLastName().isEmpty() || studentOfficer.getLastName().isBlank()) {
            throw new Exception("Prezime službenika mora biti uneto.");
        }
        if (studentOfficer.getEmail() == null) {
            throw new Exception("E-mail adresa službenika mora biti uneta.");
        }
        if (studentOfficer.getEmail().equals(studentOfficer.getFirstName() + "." + studentOfficer.getLastName() + "@fon.bg.ac.rs")) {
            throw new Exception("E-mail adresa službenika nije validna.");
        }
        if (studentOfficer.getHashedPassword() == null || !studentOfficer.getHashedPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,}$")) {
            throw new Exception("Lozinka mora da bude dugačka najmanje 8 karaktera, koje čine bar jedno malo slovo, bar jedno veliko slovo, bar jedan broj i bar jedan specijalan karakter (@, $, !, %, *, ?, &).");
        }
        if (studentOfficer.getQuestion() == null || studentOfficer.getQuestion().isEmpty() || studentOfficer.getQuestion().isBlank()) {
            throw new Exception("Sigurnosno pitanje mora biti uneto.");
        }
        if (studentOfficer.getHashedAnswer() == null || studentOfficer.getHashedAnswer().isEmpty() || studentOfficer.getHashedAnswer().isBlank()) {
            throw new Exception("Odgovor na sigurnosno pitanje mora biti uneto.");
        }
    }

    @Override
    public void checkComplexContraints(Object object) throws Exception {
    }

}
