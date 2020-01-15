/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Renz
 */
@Entity
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    
    @OneToMany(mappedBy = "student", orphanRemoval=true)
    private List<SignUp> signups = new ArrayList<>();
    
    public Student(){
        
    }

    public Student(String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public List<SignUp> getSignups() {
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

    public void setSignups(SignUp signups) {
        this.signups.add(signups);
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", email=" + email + ", signups=" + signups + '}';
    }

  
}
