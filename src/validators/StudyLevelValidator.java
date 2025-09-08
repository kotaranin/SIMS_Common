/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validators;

import domain.StudyLevel;

/**
 *
 * @author kotar
 */
public class StudyLevelValidator implements AbstractValidator {

    @Override
    public void checkElementaryContraints(Object object) throws Exception {
        if (object == null) {
            throw new Exception("Objekat ne sme biti null.");
        }
        if (!(object instanceof StudyLevel)) {
            throw new Exception("Objekat nije instanca klase StudyLevel.");
        }
        StudyLevel studyLevel = (StudyLevel) object;
        if (studyLevel.getName() == null || studyLevel.getName().isEmpty() || studyLevel.getName().isBlank()) {
            throw new Exception("Naziv nivoa studija mora biti unet.");
        }
    }

    @Override
    public void checkComplexContraints(Object object) throws Exception {
    }

}
