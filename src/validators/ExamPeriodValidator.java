/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validators;

import domain.ExamPeriod;

/**
 *
 * @author kotar
 */
public class ExamPeriodValidator implements AbstractValidator{

    @Override
    public void checkElementaryContraints(Object object) throws Exception {
        if (object == null)
            throw new Exception("Objekat ne sme biti null.");
        if (!(object instanceof ExamPeriod))
            throw new Exception("Objekat nije instanca klase ExamPeriod.");
        ExamPeriod examPeriod = (ExamPeriod) object;
        if (examPeriod.getName() == null || examPeriod.getName().isEmpty() || examPeriod.getName().isBlank())
            throw new Exception("Naziv ispitnog roka mora biti unet.");
        if (examPeriod.getStartDate() == null)
            throw new Exception("Datum početka ispitnog roka mora biti unet.");
        if (examPeriod.getEndDate() == null)
            throw new Exception("Datum završetka ispitnog roka mora biti unet.");
        if (examPeriod.getStartDate().isEqual(examPeriod.getEndDate()) || examPeriod.getStartDate().isAfter(examPeriod.getEndDate()))
            throw new Exception("Datum početka mora biti bre datuma završetka ispitnog roka.");
    }

    @Override
    public void checkComplexContraints(Object object) throws Exception {
    }
    
}
