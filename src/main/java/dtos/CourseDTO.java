/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Course;

/**
 *
 * @author Renz
 */
public class CourseDTO {
    private Integer id;
    private String courseName;
    private String description;
    
    public CourseDTO(){
        
    }
    
    public CourseDTO(Course course){
        if(course.getId() !=null){
            this.id = course.getId();
        }
        
        this.courseName = course.getCourseName();
        this.description = course.getDescription();
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CourseDTO{" + "id=" + id + ", courseName=" + courseName + ", description=" + description + '}';
    }
    
    
}
