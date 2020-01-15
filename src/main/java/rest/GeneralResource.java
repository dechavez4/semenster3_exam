/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import dtos.ClassmDTO;
import dtos.CourseDTO;
import entities.Classm;
import entities.Course;
import entities.SignUp;
import entities.Student;
import entities.Teacher;
import facades.GeneralFacade;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;
import utils.SetupTestUsers;

/**
 *
 * @author Renz
 */
@Path("school")
public class GeneralResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/fullstack_spa",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
    private static final GeneralFacade FACADE = GeneralFacade.getGeneralFacade(EMF);

    @GET
    @Path("setup")
    @Produces(MediaType.APPLICATION_JSON)
    public CourseDTO setup() {
        EntityManager em = EMF.createEntityManager();
        Course course = new Course("IT", "IT is a good course");
        Classm class1 = new Classm("1", 30);
        Teacher teacher = new Teacher("Vincent");

        Date passedDate = Date.valueOf(LocalDate.now());
        SignUp signup = new SignUp("10");
        Student student = new Student("Renz", "renz@hotmail.com");

        class1.setTeacher(teacher);
        signup.setStudent(student);
        signup.setPassedDate(passedDate);
        course.setClassm(class1);
        class1.setSignUp(signup);

        CourseDTO cDTO = new CourseDTO(course);
        try {
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return cDTO;
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CourseDTO> getAllCourseInfo() {
        System.out.println(FACADE.GetAllCourse());
        return FACADE.GetAllCourse();
    }
    
    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CourseDTO deleteCourse(@PathParam("id") int id){
        return FACADE.deleteCourse(id);
    }
    
    @DELETE
    @Path("delete/classm/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ClassmDTO deleteClassm(@PathParam("id") int id){
        return FACADE.deleteClassm(id);
    }
}
