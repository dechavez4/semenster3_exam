/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Classm;
import entities.Course;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renz
 */
public class CourseDTO {
    private Integer id;
    private String courseName;
    private String description;
    private List<ClassmDTO> classms = new ArrayList<>();
    
    public CourseDTO(){
        
    }
    
    public CourseDTO(Course course){
        if(course.getId() !=null){
            this.id = course.getId();
        }
        
        this.courseName = course.getCourseName();
        this.description = course.getDescription();
        
        for (Classm classm : course.getClassms()) {
            this.classms.add(new ClassmDTO(classm));
        }
        
    }

    public Integer getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDescription() {
        return description;
    }

    public List<ClassmDTO> getClassms() {
        return classms;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setClassms(List<ClassmDTO> classms) {
        this.classms = classms;
    }

    @Override
    public String toString() {
        return "CourseDTO{" + "id=" + id + ", courseName=" + courseName + ", description=" + description + ", classms=" + classms + '}';
    }

 
    
    
}
