/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package validators;

/**
 *
 * @author kotar
 */
public interface AbstractValidator {

    public void checkElementaryContraints(Object object) throws Exception;

    public void checkComplexContraints(Object object) throws Exception;
}
