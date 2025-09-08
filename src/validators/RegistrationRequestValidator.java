/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validators;

import domain.RegistrationRequest;

/**
 *
 * @author kotar
 */
public class RegistrationRequestValidator implements AbstractValidator {

    @Override
    public void checkElementaryContraints(Object object) throws Exception {
        if (object == null) {
            throw new Exception("Objekat ne sme biti null.");
        }
        if (!(object instanceof RegistrationRequest)) {
            throw new Exception("Objekat nije instanca klase RegistrationRequest.");
        }
        RegistrationRequest registrationRequest = (RegistrationRequest) object;
        if (registrationRequest.getFirstName() == null || registrationRequest.getFirstName().isEmpty() || registrationRequest.getFirstName().isBlank()) {
            throw new Exception("Ime službenika mora biti uneto.");
        }
        if (registrationRequest.getLastName() == null || registrationRequest.getLastName().isEmpty() || registrationRequest.getLastName().isBlank()) {
            throw new Exception("Prezime službenika mora biti uneto.");
        }
        if (registrationRequest.getEmail() == null || registrationRequest.getEmail().isEmpty() || registrationRequest.getEmail().isBlank()) {
            throw new Exception("E-mail adresa službenika mora biti uneta.");
        }
        if (!registrationRequest.getEmail().equals(registrationRequest.getFirstName().toLowerCase() + "." + registrationRequest.getLastName().toLowerCase() + "@fon.bg.ac.rs")) {
            throw new Exception("E-mail adresa službenika nije validna.");
        }
        if (registrationRequest.getHashedPassword() == null || !registrationRequest.getHashedPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,}$")) {
            throw new Exception("Lozinka mora da bude dugačka najmanje 8 karaktera, koje čine bar jedno malo slovo, bar jedno veliko slovo, bar jedan broj i bar jedan specijalan karakter (@, $, !, %, *, ?, &).");
        }
        if (registrationRequest.getQuestion() == null || registrationRequest.getQuestion().isEmpty() || registrationRequest.getQuestion().isBlank()) {
            throw new Exception("Sigurnosno pitanje mora biti uneto.");
        }
        if (registrationRequest.getHashedAnswer() == null || registrationRequest.getHashedAnswer().isEmpty() || registrationRequest.getHashedAnswer().isBlank()) {
            throw new Exception("Odgovor na sigurnosno pitanje mora biti unet.");
        }
    }

    @Override
    public void checkComplexContraints(Object object) throws Exception {
    }

}
