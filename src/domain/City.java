/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Uros
 */
public class City implements Serializable, AbstractDO {

    private Long idCity;
    private String name;
    private Country country;

    public City() {
    }

    public City(Long idCity, String name, Country country) {
        this.idCity = idCity;
        this.name = name;
        this.country = country;
    }

    public Long getIdCity() {
        return idCity;
    }

    public void setIdCity(Long idCity) {
        this.idCity = idCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getTable() {
        return "city";
    }

    @Override
    public List<AbstractDO> getList(ResultSet resultSet) throws Exception {
        List<AbstractDO> cities = new LinkedList<>();
        while (resultSet.next()) {
            City city = new City();
            city.setIdCity(resultSet.getLong(getTable() + ".id_city"));
            city.setName(resultSet.getString(getTable() + ".name"));
            Country country = new Country();
            country.setIdCountry(resultSet.getLong(country.getTable() + ".id_country"));
            country.setName(resultSet.getString(country.getTable() + ".name"));
            city.setCountry(country);
            cities.add(city);
        }
        return cities;
    }


    @Override
    public String getPrimaryKey() {
        return getTable() + ".id_city = " + idCity;
    }

    @Override
    public AbstractDO getObject(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getInsertParameters() {
        return "?, ?";
    }

    @Override
    public String getUpdateParameters() {
        return "name = ?, id_country = ?";
    }

    @Override
    public void prepareInsertStatement(PreparedStatement preparedStatement) throws Exception {
        preparedStatement.setString(1, "name");
        preparedStatement.setString(2, "id_country");
        preparedStatement.setString(3, name);
        preparedStatement.setLong(4, country.getIdCountry());
    }

    @Override
    public void prepareUpdateStatement(PreparedStatement preparedStatement) throws Exception {
        preparedStatement.setString(1, name);
        preparedStatement.setLong(2, country.getIdCountry());
    }

}
