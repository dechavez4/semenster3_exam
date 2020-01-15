/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Teacher;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renz
 */
public class TeacherDTO {
    private Integer id;
    private String name;
    private List<ClassmDTO> classms = new ArrayList<>();

    public TeacherDTO(){
        
    }

    public TeacherDTO(Teacher teacher) {
        if(teacher.getId() != null){
            this.id = teacher.getId();
        }
    
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ClassmDTO> getClassms() {
        return classms;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassms(List<ClassmDTO> classms) {
        this.classms = classms;
    }

    @Override
    public String toString() {
        return "TeacherDTO{" + "id=" + id + ", name=" + name + ", classms=" + classms + '}';
    }
    
    

    
    
}
