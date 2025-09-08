/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validators;

import domain.City;

/**
 *
 * @author kotar
 */
public class CityValidator implements AbstractValidator{

    @Override
    public void checkElementaryContraints(Object object) throws Exception {
        if (object == null)
            throw new Exception("Objekat ne sme biti null.");
        if (!(object instanceof City))
            throw new Exception("Objekat nije instanca klase City.");
        City city = (City) object;
        if (city.getName() == null || city.getName().isEmpty() || city.getName().isBlank())
            throw new Exception("Naziv grada mora biti unet.");
    }

    @Override
    public void checkComplexContraints(Object object) throws Exception {
    }
    
}
