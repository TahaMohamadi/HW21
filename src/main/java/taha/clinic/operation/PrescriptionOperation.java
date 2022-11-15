package taha.clinic.operation;

import taha.clinic.entity.MedicalRecord;
import taha.clinic.entity.Patient;
import taha.clinic.entity.Prescription;
import taha.clinic.repository.medicalRecord.impl.MedicalRecordRepoImpl;
import taha.clinic.repository.patient.impl.PatientRepoImpl;
import taha.clinic.repository.prescription.impl.PrescriptionRepoImpl;
import taha.clinic.service.medicalRecord.MedicalRecordService;
import taha.clinic.service.medicalRecord.impl.MedicalRecordServiceImpl;
import taha.clinic.service.patient.PatientService;
import taha.clinic.service.patient.impl.PatientServiceImpl;
import taha.clinic.service.prescription.PrescriptionService;
import taha.clinic.service.prescription.impl.PrescriptionServiceImpl;
import taha.clinic.util.Hibernate;

import java.util.List;

public class PrescriptionOperation {
    private final PrescriptionService prescriptionService = new PrescriptionServiceImpl(new PrescriptionRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final PatientService patientService = new PatientServiceImpl(new PatientRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final MedicalRecordService medicalRecord = new MedicalRecordServiceImpl(new MedicalRecordRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));

    public void showAll(MedicalRecord medicalRecord) {
        Patient patient = patientService.findByMedicalRecord(medicalRecord);
        List<Prescription> prescriptions = prescriptionService.findByPatient(patient);
        prescriptions.forEach(prescription -> {
            System.out.println(prescription.getId() + ".");
            prescription.getDrugs().forEach(drug -> {
                System.out.println("drug name: "+ drug.getName() + " - dose: " + drug.getDose());
            });
        });
    }


}
