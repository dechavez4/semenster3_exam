/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.CourseDTO;
import dtos.StudentDTO;
import entities.Classm;
import entities.Course;
import entities.SignUp;
import entities.Student;
import entities.Teacher;
import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

/**
 *
 * @author Renz
 */
public class FacadeCourseTest {

    private static EntityManagerFactory emf;
    private static GeneralFacade facade;
    private static Course c1, c2;
    private static CourseDTO cDTO;
    private static Classm class1;
    private static Teacher t1;
    private static Date pDate;
    private static SignUp sUp;
    private static Student s1;

    public FacadeCourseTest() {

    }

    //connector to database
    @BeforeAll
    public static void setUpClassV2() {
        emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.TEST, EMF_Creator.Strategy.DROP_AND_CREATE);
        facade = GeneralFacade.getGeneralFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    //bruges til at persist til database.
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        c1 = new Course("IT", "IT is a good course");
        class1 = new Classm("spring2020, fall2020, summer2020", 30);
        t1 = new Teacher("Vincent");

        pDate = Date.valueOf(LocalDate.now());
        sUp = new SignUp("10");
        Student student = new Student("Renz", "renz@hotmail.com");

        class1.setTeacher(t1);
        sUp.setStudent(student);
        sUp.setPassedDate(pDate);
        c1.setClassm(class1);
        class1.setSignUp(sUp);
        try {
            em.getTransaction().begin();
            em.createQuery("delete from SignUp").executeUpdate();
            em.createQuery("delete from Student").executeUpdate();
            em.createQuery("delete from Classm").executeUpdate();
            em.createQuery("delete from Course").executeUpdate();
            em.createQuery("delete from Teacher").executeUpdate();
            em.persist(c1);

            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    @Test
    public void testGetAllCourses() {
        assertEquals(1, facade.GetAllCourse().size());
    }

    @Test
    public void testDeleteCourse() {
        int expected = facade.GetAllCourse().size();
        facade.deleteCourse(c1.getId());
        expected -= 1;
        assertEquals(expected, facade.GetAllCourse().size());
    }

    /*
    @Test
    public void testGetStudentByID() {
        StudentDTO expected = new StudentDTO(s1);
        assertEquals(expected, facade.getStudentByID(s1.getName()));
    }
     */
 /*
    @Test
    public void testAddCourse() {
        EntityManager em = emf.createEntityManager();
        c1 = new Course("IT", "IT is a good course");
        cDTO = new CourseDTO(c1);

        CourseDTO expected = facade.addCourse(cDTO);

        CourseDTO actual = new CourseDTO(em.find(Course.class, expected.getId()));
        assertEquals(expected, actual);
    }
     */
}
