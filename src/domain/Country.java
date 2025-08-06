/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Uros
 */
public class Country implements Serializable, AbstractDomainObject {

    private Long idCountry;
    private String name;

    public Country() {
    }

    public Country(Long idCountry, String name) {
        this.idCountry = idCountry;
        this.name = name;
    }

    public Long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Long idCountry) {
        this.idCountry = idCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getTable() {
        return "country";
    }

    @Override
    public List<AbstractDomainObject> getList(ResultSet resultSet) throws Exception {
        List<AbstractDomainObject> countries = new LinkedList<>();
        while (resultSet.next()) {
            Country country = new Country();
            country.setIdCountry(resultSet.getLong(getTable() + ".id_country"));
            country.setName(resultSet.getString(getTable() + ".name"));
            countries.add(country);
        }
        return countries;
    }

    @Override
    public String getInsertColumns() {
        return "name";
    }

    @Override
    public String getInsertValues() {
        return "'" + name + "'";
    }

    @Override
    public String getPrimaryKey() {
        return getTable() + ".id_country = " + idCountry;
    }

    @Override
    public AbstractDomainObject getObject(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateValues() {
        return "name = '" + name + "'";
    }

}
