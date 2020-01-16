/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entities.Classm;
import entities.Course;
import entities.SignUp;
import entities.Student;
import entities.Teacher;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.parsing.Parser;
import java.net.URI;
import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.util.HttpStatus;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

/**
 *
 * @author Renz
 */
public class GeneralResourceTest {

    private static final int SERVER_PORT = 7777;
    private static final String SERVER_URL = "http://localhost/api";
    private static Course c1, c2;
    private static Classm class1;
    private static Teacher t1;
    private static Date pDate;
    private static SignUp sUp;
    private static Student s;

    static final URI BASE_URI = UriBuilder.fromUri(SERVER_URL).port(SERVER_PORT).build();
    private static HttpServer httpServer;
    private static EntityManagerFactory emf;

    static HttpServer startServer() {
        ResourceConfig rc = ResourceConfig.forApplication(new ApplicationConfig());
        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
    }

    @BeforeAll
    public static void setUpClass() {
        //This method must be called before you request the EntityManagerFactory
        EMF_Creator.startREST_TestWithDB();
        emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.TEST, EMF_Creator.Strategy.CREATE);

        httpServer = startServer();
        //Setup RestAssured
        RestAssured.baseURI = SERVER_URL;
        RestAssured.port = SERVER_PORT;
        RestAssured.defaultParser = Parser.JSON;
    }

    @AfterAll
    public static void closeTestServer() {
        //Don't forget this, if you called its counterpart in @BeforeAll
        EMF_Creator.endREST_TestWithDB();
        httpServer.shutdownNow();
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
    public void testGetAllCourses() throws Exception {
        given()
                .contentType("application/json")
                .get("/school/all").then()
                .assertThat()
                .statusCode(HttpStatus.OK_200.getStatusCode())
                .body("size()", equalTo(1));
    }
    /*
    @Test
    public void testDeleteCourse() throws Exception{
        given()
               .contentType("application/json")
              .get("/school/delete/" + c1.getId()).then()
               .assertThat()
                .statusCode(HttpStatus.OK_200.getStatusCode())
                .body("id", equalTo(c1.getId())); 
                
    }
    */
    /*

    @Test
    public void testGetStudentById() throws Exception {
        given()
                .contentType("application/json")
                .get("/school/studentid/" + s.getId()).then()
                .assertThat()
                .statusCode(HttpStatus.OK_200.getStatusCode())
                .body("id", equalTo(s.getName()));
        //enten skal det være equalTo s.getId eller s.getName
    }
    */
    /*
    @Test
    public void testDeleteCourseByID() throws Exception {
        given()
                .contentType("application/json")
                .delete("/school/delete/classm/" + class1.getId()).then()
                .assertThat()
                .statusCode(HttpStatus.OK_200.getStatusCode())
                .body("size()", equalTo(1));
    }
     */

}
