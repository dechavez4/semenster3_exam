/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Classm;
import entities.Teacher;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renz
 */
public class ClassmDTO {
    private Integer id;
    private String semester;
    private int maxNumberOfStudents;
    
    public ClassmDTO(){
        
    }

    public ClassmDTO(Classm classm) {
        if(classm.getId() != null){
            this.id = classm.getId();
        }
        this.semester = classm.getSemester();
        this.maxNumberOfStudents = classm.getMaxNumberOfStudents();

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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setMaxNumberOfStudents(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    @Override
    public String toString() {
        return "ClassmDTO{" + "id=" + id + ", semester=" + semester + ", maxNumberOfStudents=" + maxNumberOfStudents + '}';
    }
    
    
    
}
