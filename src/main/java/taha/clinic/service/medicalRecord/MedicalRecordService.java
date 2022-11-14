package taha.clinic.service.medicalRecord;

import taha.clinic.base.service.BaseService;
import taha.clinic.entity.MedicalRecord;
import taha.clinic.entity.Patient;

public interface MedicalRecordService extends BaseService<MedicalRecord> {
    MedicalRecord findByPatient(Patient patient);
}
