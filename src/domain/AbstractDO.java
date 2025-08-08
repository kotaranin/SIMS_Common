/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Uros
 */
public interface AbstractDO extends Serializable {

    public String getTable();

    public List<AbstractDO> getList(ResultSet resultSet) throws Exception;

    public String getPrimaryKey();

    public AbstractDO getObject(ResultSet resultSet) throws Exception;

    public String getInsertParameters();

    public String getUpdateParameters();

    public void prepareInsertStatement(PreparedStatement preparedStatement) throws Exception;

    public void prepareUpdateStatement(PreparedStatement preparedStatement) throws Exception;

}
