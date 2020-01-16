/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.ClassmDTO;
import dtos.CourseDTO;
import dtos.StudentDTO;
import entities.Classm;
import entities.Course;
import entities.Student;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Renz
 */
public class GeneralFacade {

    private static GeneralFacade instance;
    private static EntityManagerFactory emf;

    public static GeneralFacade getGeneralFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new GeneralFacade();
        }
        return instance;
    }

    public List<CourseDTO> GetAllCourse() {
        EntityManager em = emf.createEntityManager();
        List<CourseDTO> listDTO = new ArrayList<>();
        try {
            List<Course> list = em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
            for (Course course : list) {
                listDTO.add(new CourseDTO(course));
            }
        } finally {
            em.close();
        }

        return listDTO;
    }

    public CourseDTO addCourse(CourseDTO course) {
        EntityManager em = emf.createEntityManager();
        Course c = new Course(course.getCourseName(), course.getDescription());
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return new CourseDTO(c);
    }

    public CourseDTO deleteCourse(int id) {
        EntityManager em = emf.createEntityManager();
        Course course = em.find(Course.class, id);
        try {
            em.getTransaction().begin();
            em.remove(course);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new CourseDTO(course);
    }

    public ClassmDTO deleteClassm(int id) {
        EntityManager em = emf.createEntityManager();
        Classm classm = em.find(Classm.class, id);
        try {
            em.getTransaction().begin();
            em.remove(classm);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new ClassmDTO(classm);
    }

    public StudentDTO getStudentByID(String username) {
        EntityManager em = emf.createEntityManager();
        //Student s = em.find(Student.class, username);
        
        Student foundStudent = (Student)em.createQuery("SELECT s FROM Student s WHERE s.name = '" + username + "'", Student.class).getSingleResult();
        
        try {
            StudentDTO student = new StudentDTO(foundStudent);
            return student;
        }finally{
            em.close();
        }
    }

}
