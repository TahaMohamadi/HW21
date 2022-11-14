package taha.clinic.operation;

import taha.clinic.repository.clinic.impl.ClinicRepoImpl;
import taha.clinic.repository.doctor.Impl.DoctorRepoImpl;
import taha.clinic.service.clinic.ClinicService;
import taha.clinic.service.clinic.impl.ClinicServiceImpl;
import taha.clinic.service.doctor.DoctorService;
import taha.clinic.service.doctor.impl.DoctorServiceImpl;
import taha.clinic.util.Hibernate;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DoctorOperation {
    private final ClinicService clinicService = new ClinicServiceImpl(new ClinicRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final DoctorService doctorService = new DoctorServiceImpl(new DoctorRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    ClinicOperation clinicOperation = new ClinicOperation();
    public void findByClinic(Long id) {
    }

    public List<Doctor> findByClinicId(Long id) {
            Clinic clinic = clinicOperation.findByClinicId(id);
            System.out.println(clinic);
            List<Doctor> doctors = doctorService.findByClinic(clinic);
            AtomicInteger a = new AtomicInteger(0);
            String clinicName = clinic.getName();
            String s = String.format(("----------------- clinic %S doctors -----------------"),clinicName);
            System.out.println(s);
            doctors.forEach(doctor -> {
                a.getAndIncrement();
                System.out.println(a +". "+ doctor.getPerson().getFirstName() + " "+ doctor.getPerson().getLastName() + "  -> id: " + doctor.getId());
            });


        return doctors;

    }
}
