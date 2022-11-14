package taha.clinic.operation;

import taha.clinic.entity.Drug;
import taha.clinic.repository.drug.impl.DrugRepoImpl;
import taha.clinic.service.drug.DrugService;
import taha.clinic.service.drug.impl.DrugServiceImpl;
import taha.clinic.util.Hibernate;

import java.util.List;
import java.util.Scanner;

public class DrugOperation {
    private final Scanner scanner = new Scanner(System.in);
    private final DrugService drugService = new DrugServiceImpl(new DrugRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));

    public List<Drug> getDrugList() {
        List<Drug> drugs = null;
        while (true){
            System.out.println("enter a drug name or if finish just type finish: ");
            String name = scanner.next();
            Drug drug = drugService.findByName(name);
            drugs.add(drug);
        if( name == "finish"){
            return drugs;
        }
        }

    }
}
