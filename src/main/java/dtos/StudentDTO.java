/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.SignUp;
import entities.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renz
 */
public class StudentDTO {
    private Integer id;
    private String name;
    private String email;
    private List<SignUpDTO> signups = new ArrayList<>();
    
    public StudentDTO(){
        
    }
    
    public StudentDTO(Student student){
        if(student.getId() != null){
            this.id = student.getId();
        }
        this.name = student.getName();
        this.email = student.getEmail();
        if(student.getSignups() != null){
            for (SignUp signup : student.getSignups()) {
                this.signups.add(new SignUpDTO(signup));
            }
        }
        
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<SignUpDTO> getSignups() {
        return signups;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSignups(List<SignUpDTO> signups) {
        this.signups = signups;
    }

    @Override
    public String toString() {
        return "StudentDTO{" + "id=" + id + ", name=" + name + ", email=" + email + ", signups=" + signups + '}';
    }
    
    
}
