package taha.clinic.service.medicalRecord.impl;

import taha.clinic.base.service.impl.BaseServiceImpl;
import taha.clinic.entity.MedicalRecord;
import taha.clinic.entity.Patient;
import taha.clinic.repository.medicalRecord.MedicalRecordRepo;
import taha.clinic.service.medicalRecord.MedicalRecordService;

public class
MedicalRecordServiceImpl extends BaseServiceImpl<MedicalRecord, MedicalRecordRepo> implements MedicalRecordService {

    public MedicalRecordServiceImpl(MedicalRecordRepo repository) {
        super(repository);
    }

    @Override
    public MedicalRecord findByPatient(Patient patient) {
        try{
            return repository.findByPatient(patient);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
