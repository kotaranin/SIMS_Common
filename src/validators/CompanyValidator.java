/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validators;

import domain.Company;

/**
 *
 * @author kotar
 */
public class CompanyValidator implements AbstractValidator {

    @Override
    public void checkElementaryContraints(Object object) throws Exception {
        if (object == null) {
            throw new Exception("Objekat ne sme biti null.");
        }
        if (!(object instanceof Company)) {
            throw new Exception("Objekat nije instanca klase Company.");
        }
        Company company = (Company) object;
        if (company.getName() == null || company.getName().isEmpty() || company.getName().isBlank()) {
            throw new Exception("Ime kompanije mora biti uneto.");
        }
        if (company.getAddress() == null || company.getAddress().isEmpty() || company.getAddress().isBlank()) {
            throw new Exception("Adresa kompanije mora biti uneta.");
        }
        if (company.getCity() == null)
            throw new Exception("Grad mora biti unet.");
    }

    @Override
    public void checkComplexContraints(Object object) throws Exception {
    }

}
