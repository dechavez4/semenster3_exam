/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.CourseDTO;
import entities.Classm;
import entities.Course;
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
   
}
