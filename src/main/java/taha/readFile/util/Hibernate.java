package taha.readFile.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Hibernate {

    private Hibernate(){}
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("fileReader");

    public static EntityManagerFactory getEntityManagerFactory(){return ENTITY_MANAGER_FACTORY;}

}
