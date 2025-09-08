/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validators;

import domain.Teacher;

/**
 *
 * @author kotar
 */
public class TeacherValidator implements AbstractValidator{

    @Override
    public void checkElementaryContraints(Object object) throws Exception {
        if (object == null) {
            throw new Exception("Objekat ne sme biti null.");
        }
        if (!(object instanceof Teacher)) {
            throw new Exception("Objekat nije instanca klase Teacher.");
        }
        Teacher teacher = (Teacher) object;
        if (teacher.getFirstName() == null || teacher.getFirstName().isEmpty() || teacher.getFirstName().isBlank()) {
            throw new Exception("Ime mora biti uneto.");
        }
        if (teacher.getLastName() == null || teacher.getLastName().isEmpty() || teacher.getLastName().isBlank()) {
            throw new Exception("Prezime mora biti uneto.");
        }
    }

    @Override
    public void checkComplexContraints(Object object) throws Exception {
    }
    
}
