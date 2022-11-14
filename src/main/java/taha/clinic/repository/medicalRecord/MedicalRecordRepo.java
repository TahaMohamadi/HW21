package taha.clinic.repository.medicalRecord;

import taha.clinic.base.repository.BaseRepository;
import taha.clinic.entity.MedicalRecord;
import taha.clinic.entity.Patient;

public interface MedicalRecordRepo extends BaseRepository<MedicalRecord> {
    MedicalRecord findByPatient(Patient patient);
}
