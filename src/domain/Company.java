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
public class Company implements Serializable, AbstractDO {

    private Long idCompany;
    private String name;
    private String address;
    private City city;

    public Company() {
    }

    public Company(Long idCompany, String name, String adress, City city) {
        this.idCompany = idCompany;
        this.name = name;
        this.address = adress;
        this.city = city;
    }

    public Long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Long idCompany) {
        this.idCompany = idCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getTable() {
        return "company";
    }

    @Override
    public List<AbstractDO> getList(ResultSet resultSet) throws Exception {
        List<AbstractDO> companies = new LinkedList<>();
        while (resultSet.next()) {
            Company company = new Company();
            company.setIdCompany(resultSet.getLong(getTable()+".id_company"));
            company.setName(resultSet.getString(getTable() + ".name"));
            company.setAddress(resultSet.getString(getTable() + ".address"));
            
            City city = new City();
            city.setIdCity(resultSet.getLong(city.getTable() + ".id_city"));
            city.setName(resultSet.getString(city.getTable() + ".name"));
            Country country = new Country();
            country.setIdCountry(resultSet.getLong(country.getTable() + ".id_country"));
            country.setName(resultSet.getString(country.getTable() + ".name"));
            city.setCountry(country);
            company.setCity(city);
            
            companies.add(company);
        }
        return companies;
    }

    @Override
    public String getPrimaryKey() {
        return getTable() + ".id_company = " + idCompany;
    }

    @Override
    public String getInsertParameters() {
        return "?, ?, ?";
    }

    @Override
    public String getUpdateParameters() {
        return "name = ?, address = ?, id_city = ?";
    }

    @Override
    public void prepareStatement(PreparedStatement preparedStatement) throws Exception {
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, address);
        preparedStatement.setLong(3, city.getIdCity());
    }

    @Override
    public String getInsertColumns() {
        return "name, address, id_city";
    }

}
