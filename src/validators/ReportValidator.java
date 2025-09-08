/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validators;

import domain.Report;

/**
 *
 * @author kotar
 */
public class ReportValidator implements AbstractValidator{

    @Override
    public void checkElementaryContraints(Object object) throws Exception {
        if (object == null)
            throw new Exception("Objekat ne sme biti null.");
        if (!(object instanceof Report))
            throw new Exception("Objekat nije instanca klase Report.");
        Report report = (Report) object;
        if (report.getFileName() == null || report.getFileName().isEmpty() || report.getFileName().isBlank())
            throw new Exception("Naziv dnevnika prakse mora biti unet.");
        if (report.getFileContent() == null)
            throw new Exception("Podaci dnevnika prakse moraju biti uneti.");
    }

    @Override
    public void checkComplexContraints(Object object) throws Exception {
    }
    
}
