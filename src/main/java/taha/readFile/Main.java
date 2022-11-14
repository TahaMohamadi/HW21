package taha.readFile;

import taha.readFile.util.Hibernate;
import jakarta.persistence.EntityManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        EntityManager em = Hibernate.getEntityManagerFactory().createEntityManager();
            FileReader fileReader = new FileReader("information.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);



    }

}
