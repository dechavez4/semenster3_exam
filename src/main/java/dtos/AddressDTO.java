/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Address;

/**
 *
 * @author vince
 */
public class AddressDTO {
    private Integer id;
    private String street;
    private String city;
    private String zip;

    public AddressDTO() {
    }

    public AddressDTO(Address address) {
        this.id = address.getId();
        this.street = address.getStreet();
        this.city = address.getCity();
        this.zip = address.getZip();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "AddressDTO{" + "street=" + street + ", city=" + city + ", zip=" + zip + '}';
    }
    
}
