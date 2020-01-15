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

/**
 *
 * @author Renz
 */
@Entity
public class Classm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String semester;
    private int maxNumberOfStudents;
    
    private List<Course> courses = new ArrayList<>();
    
    private SignUp signUp;

    
    public Classm(){
        
    }
    
    public Classm(String semester, int maxNumberOfStudents) {
        this.id = id;
        this.semester = semester;
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public Long getId() {
        return id;
    }

    public String getSemester() {
        return semester;
    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public SignUp getSignUp() {
        return signUp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setMaxNumberOfStudents(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setSignUp(SignUp signUp) {
        this.signUp = signUp;
    }

 

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classm)) {
            return false;
        }
        Classm other = (Classm) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Class[ id=" + id + " ]";
    }
    
}
