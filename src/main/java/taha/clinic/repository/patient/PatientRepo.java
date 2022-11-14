package taha.clinic.repository.patient;

import taha.clinic.base.repository.BaseRepository;
import taha.clinic.entity.MedicalRecord;
import taha.clinic.entity.Patient;
import taha.clinic.entity.UserAccount;

import java.util.List;

public interface PatientRepo extends BaseRepository<Patient> {
    Patient findByUserAccount(UserAccount userAccount);

    Patient findByMedicalRecord(MedicalRecord medicalRecord);

    List<Patient> findAllPatient();

    Patient patientDesc(Long patientId);
}
