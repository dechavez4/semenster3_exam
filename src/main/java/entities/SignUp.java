/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Renz
 */
@Entity
public class SignUp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String grade;
    @Temporal(TemporalType.DATE)
    private Date passedDate;
    
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Student student;
    
    @ManyToOne
    private Classm classm;
    
    public SignUp(){
        
    }

    public SignUp(String grade, Date passedDate) {
        this.id = id;
        this.grade = grade;
        this.passedDate = passedDate;
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
