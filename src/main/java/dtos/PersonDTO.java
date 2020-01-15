/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Hobby;
import entities.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vince
 */
public class PersonDTO {
    private Integer id;
    private String fName;
    private String lName;
    private String phone;
    private String email;
    private AddressDTO address;
    private List<HobbyDTO> hobbies = new ArrayList<>();

    public PersonDTO() {
    }

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.fName = person.getFirstName();
        this.lName = person.getLastName();
        this.phone = person.getPhone();
        this.email = person.getEmail();
        this.address = new AddressDTO(person.getAddress());

        for (Hobby hobby : person.getHobbies()) {
            hobbies.add(new HobbyDTO(hobby));
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public List<HobbyDTO> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<HobbyDTO> hobbies) {
        this.hobbies = hobbies;
    }

    public void addHobby(HobbyDTO hobby) {
        this.hobbies.add(hobby);
    }

    @Override
    public String toString() {
        return "PersonDTO{" + "id=" + id + ", fName=" + fName + ", lName=" + lName + ", phone=" + phone + ", email=" + email + ", address=" + address + ", hobbies=" + hobbies + '}';
    }



}
