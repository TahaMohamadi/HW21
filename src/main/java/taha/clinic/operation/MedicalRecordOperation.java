package taha.clinic.operation;

import taha.clinic.entity.MedicalRecord;
import taha.clinic.entity.Patient;
import taha.clinic.entity.UserAccount;
import taha.clinic.menu.MedicalRecordMenu;
import taha.clinic.repository.medicalRecord.impl.MedicalRecordRepoImpl;
import taha.clinic.repository.patient.impl.PatientRepoImpl;
import taha.clinic.service.medicalRecord.MedicalRecordService;
import taha.clinic.service.medicalRecord.impl.MedicalRecordServiceImpl;
import taha.clinic.service.patient.PatientService;
import taha.clinic.service.patient.impl.PatientServiceImpl;
import taha.clinic.util.Hibernate;

public class MedicalRecordOperation {
    private final MedicalRecordService medicalRecordService = new MedicalRecordServiceImpl(new MedicalRecordRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final PatientService patientService = new PatientServiceImpl(new PatientRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));

        public void showMedicalRecord(UserAccount userAccount) {
            Patient patient = patientService.findByUserAccount(userAccount);
            MedicalRecord medicalRecord = medicalRecordService.findByPatient(patient);
            MedicalRecordMenu medicalRecordMenu = new MedicalRecordMenu();
            medicalRecordMenu.showMenu(medicalRecord, patient);
        }
    }


