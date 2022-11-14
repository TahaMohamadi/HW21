package taha.clinic.repository.prescription;

import taha.clinic.base.repository.BaseRepository;
import taha.clinic.entity.Patient;
import taha.clinic.entity.Prescription;

import java.util.List;

public interface PrescriptionRepo extends BaseRepository<Prescription> {
    List<Prescription> findByPatient(Patient patient);
}
