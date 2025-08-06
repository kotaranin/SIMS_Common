/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Uros
 */
public interface AbstractDomainObject extends Serializable {

    public String getTable();

    public List<AbstractDomainObject> getList(ResultSet resultSet) throws Exception;

    public String getInsertColumns();

    public String getInsertValues();

    public String getPrimaryKey();

    public AbstractDomainObject getObject(ResultSet resultSet) throws Exception;

    public String getUpdateValues();
}
