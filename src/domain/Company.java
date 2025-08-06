/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Uros
 */
public class Company implements Serializable, AbstractDomainObject {

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
    public List<AbstractDomainObject> getList(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getInsertColumns() {
        return "name, address, id_city";
    }

    @Override
    public String getInsertValues() {
        return "'" + name + "', '" + address + "', " + city.getIdCity();
    }

    @Override
    public String getPrimaryKey() {
        return getTable() + ".id_company = " + idCompany;
    }

    @Override
    public AbstractDomainObject getObject(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateValues() {
        return "name = '" + name + "', address = '" + address + "', id_city = " + city.getIdCity();
    }

}
