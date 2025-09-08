/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validators;

/**
 *
 * @author kotar
 */
public class ModuleValidator implements AbstractValidator{

    @Override
    public void checkElementaryContraints(Object object) throws Exception {
        if (object == null)
            throw new Exception("Objekat ne sme biti null.");
        if (!(object instanceof domain.Module))
            throw new Exception("Objekat nije instanca klase Module.");
        domain.Module module = (domain.Module) object;
        if (module.getName() == null || module.getName().isEmpty() || module.getName().isBlank())
            throw new Exception("Naziv modula mora biti unet.");
    }

    @Override
    public void checkComplexContraints(Object object) throws Exception {
    }
    
}
