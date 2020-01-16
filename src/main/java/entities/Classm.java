/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Renz
 */
@Entity
@NamedQuery(name = "Classm.deleteAllRows", query = "DELETE from Classm")

public class Classm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String semester;
    private int maxNumberOfStudents;
    
    @ManyToOne
    private Course course;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Teacher> teachers = new ArrayList<>();
    
    @OneToMany(mappedBy = "classm", cascade = CascadeType.PERSIST, orphanRemoval=true)
    private List<SignUp> signUps = new ArrayList<>();

    
    public Classm(){
        
    }
    
    public Classm(String semester, int maxNumberOfStudents) {
        this.id = id;
        this.semester = semester;
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public Integer getId() {
        return id;
    }

    public String getSemester() {
        return semester;
    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<SignUp> getSignUps() {
        return signUps;
    }

    public Course getCourse() {
        return course;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setMaxNumberOfStudents(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public void setTeacher(Teacher teacher) {
        this.teachers.add(teacher);
        teacher.setClassm(this);
    }

    public void setSignUp(SignUp signup) {
        this.signUps.add(signup);
        signup.setClassm(this);
    }

    public void setCourse(Course course) {
        this.course = course;
    }
   
    @Override
    public String toString() {
        return "Classm{" + "id=" + id + ", semester=" + semester + ", maxNumberOfStudents=" + maxNumberOfStudents + ", teachers=" + teachers + ", signUps=" + signUps + '}';
    }
    
}
