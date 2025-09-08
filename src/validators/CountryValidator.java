/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validators;

import domain.Country;

/**
 *
 * @author kotar
 */
public class CountryValidator implements AbstractValidator{

    @Override
    public void checkElementaryContraints(Object object) throws Exception {
        if (object == null)
            throw new Exception("Objekat ne sme biti null.");
        if (!(object instanceof Country))
            throw new Exception("Objekat nije instanca klase Country.");
        Country country = (Country) object;
        if (country.getName() == null || country.getName().isEmpty() || country.getName().isBlank())
            throw new Exception("Naziv države mora biti unet.");
    }

    @Override
    public void checkComplexContraints(Object object) throws Exception {
    }
    
}
