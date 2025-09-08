/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Uros
 */
public class Country implements Serializable, AbstractDO {
    
    private Long idCountry;
    private String name;
    private List<City> cities;

    public Country() {
    }

    public Country(Long idCountry, String name, List<City> cities) {
        this.idCountry = idCountry;
        this.name = name;
        this.cities = cities;
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

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
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
    public List<AbstractDO> getList(ResultSet resultSet) throws Exception {
        List<AbstractDO> countries = new LinkedList<>();
        while (resultSet.next()) {
            Country country = new Country();
            country.setIdCountry(resultSet.getLong(getTable() + ".id_country"));
            country.setName(resultSet.getString(getTable() + ".name"));
            countries.add(country);
        }
        return countries;
    }

    @Override
    public String getPrimaryKey() {
        return getTable() + ".id_country = " + idCountry;
    }

    @Override
    public String getInsertParameters() {
        return "?";
    }

    @Override
    public String getUpdateParameters() {
        return "name = ?";
    }

    @Override
    public void prepareStatement(PreparedStatement preparedStatement) throws Exception {
        preparedStatement.setString(1, name);
    }

    @Override
    public String getInsertColumns() {
        return "name"; 
    }

}
