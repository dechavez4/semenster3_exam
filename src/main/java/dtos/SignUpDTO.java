/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Classm;
import entities.SignUp;
import entities.Student;
import java.util.Date;

/**
 *
 * @author Renz
 */
public class SignUpDTO {
    private Integer id;
    private String grade;
    private java.util.Date passedDate;
    
    private Student student;
    private Classm classm;
   
    public SignUpDTO(){
        
    }

    public SignUpDTO(SignUp signUp) {
        if(signUp.getId() !=null){
            this.id = signUp.getId();
        }
        this.grade = signUp.getGrade();
        this.passedDate = signUp.getPassedDate();
        this.student = signUp.getStudent();
        this.classm = signUp.getClassm();
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
    }

    public void setClassm(Classm classm) {
        this.classm = classm;
    }

    @Override
    public String toString() {
        return "SignUpDTO{" + "id=" + id + ", grade=" + grade + ", passedDate=" + passedDate + ", student=" + student + ", classm=" + classm + '}';
    }
    
}
