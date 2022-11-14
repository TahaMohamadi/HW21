package taha.clinic.service.prescription.impl;

import taha.clinic.base.service.impl.BaseServiceImpl;
import taha.clinic.entity.Patient;
import taha.clinic.entity.Prescription;
import taha.clinic.repository.prescription.PrescriptionRepo;
import taha.clinic.service.prescription.PrescriptionService;

import java.util.List;

public class
PrescriptionServiceImpl extends BaseServiceImpl<Prescription, PrescriptionRepo> implements PrescriptionService {

    public PrescriptionServiceImpl(PrescriptionRepo repository) {
        super(repository);
    }

    @Override
    public List<Prescription> findByPatient(Patient patient) {
        try{
            return repository.findByPatient(patient);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
