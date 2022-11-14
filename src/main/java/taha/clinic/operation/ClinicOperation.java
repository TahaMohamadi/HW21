package taha.clinic.operation;

import taha.clinic.entity.Clinic;
import taha.clinic.repository.clinic.impl.ClinicRepoImpl;
import taha.clinic.service.clinic.ClinicService;
import taha.clinic.service.clinic.impl.ClinicServiceImpl;
import taha.clinic.util.Hibernate;

import java.util.List;

public class ClinicOperation {

    private final ClinicService clinicService = new ClinicServiceImpl(new ClinicRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    public void showClinic(){
        List<Clinic> clinics = clinicService.findAllClinics();
//        System.out.println(clinics + "............ ");

        clinics.forEach(clinic -> {
//            System.out.println(clinic.toString()+".------- ");
            System.out.println(clinic.getId() + ". " + clinic.getName());
        });
    }


    public Clinic findByClinicId(Long id) {
        Clinic clinic = clinicService.findByClinicId(id);
        return clinic;

    }
}