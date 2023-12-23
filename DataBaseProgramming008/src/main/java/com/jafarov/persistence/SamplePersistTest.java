package com.jafarov.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SamplePersistTest {
    public static void main(String[] args) {
        Sample sample = new Sample(0,"Ad",3.4);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DataBaseProgramming008PU");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        manager.persist(sample);
        
        manager.getTransaction().commit();

        manager.close();


    }
}
