/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Renz
 */
@Entity
@NamedQuery(name = "SignUp.deleteAllRows", query = "DELETE from SignUp")
public class SignUp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String grade;
    
    @Temporal(TemporalType.DATE) 
    private java.util.Date passedDate;
    
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Student student;
    
    @ManyToOne
    private Classm classm;
    
    public SignUp(){
        
    }

    public SignUp(String grade) {
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public String getGrade() {
        return grade;
    }

    public Date getPassedDate() {
        return passedDate;
    }

    public Student getStudent() {
        return student;
    }

    public Classm getClassm() {
        return classm;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setPassedDate(Date passedDate) {
        this.passedDate = passedDate;
    }

    public void setStudent(Student student) {
        this.student = student;
        student.setSignups(this);
    }

    public void setClassm(Classm classm) {
        this.classm = classm;
    }

    @Override
    public String toString() {
        return "SignUp{" + "id=" + id + ", grade=" + grade + ", passedDate=" + passedDate + ", student=" + student + ", classm=" + classm + '}';
    }

    
    
}
