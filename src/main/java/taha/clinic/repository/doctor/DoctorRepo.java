package taha.clinic.repository.doctor;

import taha.clinic.base.repository.BaseRepository;
import taha.clinic.entity.Clinic;
import taha.clinic.entity.Doctor;
import taha.clinic.entity.UserAccount;

import java.util.List;

public interface DoctorRepo extends BaseRepository<Doctor> {
    static void findByPatient(Clinic clinic) {
    }


    List<Doctor> findByClinic(Clinic clinic);

    Doctor findDoctorById(Long id);

    List<Doctor> findAllDoctor();

    Doctor findByUserId(UserAccount user);
}
