package taha.clinic.service.patient;

import taha.clinic.base.service.BaseService;
import taha.clinic.entity.MedicalRecord;
import taha.clinic.entity.Patient;
import taha.clinic.entity.UserAccount;

import java.util.List;

public interface PatientService extends BaseService<Patient> {
    Patient findByUserAccount(UserAccount userAccount);

    Patient findByMedicalRecord(MedicalRecord medicalRecord);

    List<Patient> findAllPatient();

    Patient patientDesc(Long patientId);
}
