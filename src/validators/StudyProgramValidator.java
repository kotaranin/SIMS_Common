/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validators;

import domain.StudyProgram;

/**
 *
 * @author kotar
 */
public class StudyProgramValidator implements AbstractValidator {

    @Override
    public void checkElementaryContraints(Object object) throws Exception {
        if (object == null) {
            throw new Exception("Objekat ne sme biti null.");
        }
        if (!(object instanceof StudyProgram)) {
            throw new Exception("Objekat nije instanca klase StudyProgram.");
        }
        StudyProgram studyProgram = (StudyProgram) object;
        if (studyProgram.getName() == null || studyProgram.getName().isEmpty() || studyProgram.getName().isBlank()) {
            throw new Exception("Naziv studijskog programa mora biti unet.");
        }
    }

    @Override
    public void checkComplexContraints(Object object) throws Exception {
    }

}
