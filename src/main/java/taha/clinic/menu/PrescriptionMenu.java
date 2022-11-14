package taha.clinic.menu;

import taha.clinic.entity.Appointment;
import taha.clinic.entity.Drug;
import taha.clinic.entity.Prescription;
import taha.clinic.operation.DrugOperation;
import taha.clinic.repository.appointment.impl.AppointmentRepoImpl;
import taha.clinic.repository.prescription.impl.PrescriptionRepoImpl;
import taha.clinic.service.appointment.AppointmentService;
import taha.clinic.service.appointment.impl.AppointmentServiceImpl;
import taha.clinic.service.prescription.PrescriptionService;
import taha.clinic.service.prescription.impl.PrescriptionServiceImpl;
import taha.clinic.util.Hibernate;

import java.util.List;
import java.util.Optional;

public class PrescriptionMenu {
//    private final Scanner scanner = new Scanner(System.in);
//    private final DrugService drugService = new DrugServiceImpl(new DrugRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
private final AppointmentService appointmentService = new AppointmentServiceImpl(new AppointmentRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
   private final PrescriptionService prescriptionService = new PrescriptionServiceImpl(new PrescriptionRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    DrugOperation drugOperation = new DrugOperation();
public void createPrescription(Long id) {

    Optional<Appointment> appointment = appointmentService.findById(id);
    List<Drug> drugs = drugOperation.getDrugList();

    Prescription prescription = new Prescription(drugs.stream().toList(),appointment.get().getPatient(), appointment.get().getMedicalRecord(), appointment.get().getDoctor());
    prescriptionService.save(prescription);
    }
}