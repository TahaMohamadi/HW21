package taha.clinic.service.prescription;

import taha.clinic.base.service.BaseService;
import taha.clinic.entity.Patient;
import taha.clinic.entity.Prescription;

import java.util.List;

public interface PrescriptionService extends BaseService<Prescription> {
    List<Prescription> findByPatient(Patient patient);
}
