/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validators;

import domain.Student;
import java.time.LocalDate;

/**
 *
 * @author kotar
 */
public class StudentValidator implements AbstractValidator {

    @Override
    public void checkElementaryContraints(Object object) throws Exception {
        if (object == null) {
            throw new Exception("Objekat ne sme biti null.");
        }
        if (!(object instanceof Student)) {
            throw new Exception("Objekat nije instanca klase Student.");
        }
        Student student = (Student) object;
        if (student.getIndexNumber() == null || !student.getIndexNumber().matches("^[0-9]{4}/[0-9]{1,4}$")) {
            throw new Exception("Indeks mora biti u formatu GGGG/BBBB (G - godina upisa, B - broj indeksa).");
        }
        if (student.getFirstName() == null || student.getFirstName().isEmpty() || student.getFirstName().isBlank()) {
            throw new Exception("Ime mora biti uneto.");
        }
        if (student.getLastName() == null || student.getLastName().isEmpty() || student.getLastName().isBlank()) {
            throw new Exception("Prezime mora biti uneto.");
        }
        if (student.getDateOfBirth() == null) {
            throw new Exception("Datum rođenja mora biti unet.");
        }
        if (student.getDateOfBirth().isAfter(LocalDate.now())) {
            throw new Exception("Datum rođenja nije validan.");
        }
        if (student.getCity() == null) {
            throw new Exception("Grad rođenja mora biti unet.");
        }
        if (student.getYearOfStudy() == null) {
            throw new Exception("Trenutna godina studija mora biti uneta.");
        }
        if (student.getYearOfStudy() < 1) {
            throw new Exception("Trenutna godina studija mora pozitivan ceo broj.");
        }
        if (student.getStudyProgram() == null) {
            throw new Exception("Studijski program mora biti unet.");
        }
    }

    @Override
    public void checkComplexContraints(Object object) throws Exception {
    }

}
