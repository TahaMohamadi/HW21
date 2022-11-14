package taha.clinic.service.doctor;

import taha.clinic.base.service.BaseService;
import taha.clinic.entity.Clinic;
import taha.clinic.entity.Doctor;
import taha.clinic.entity.UserAccount;

import java.util.List;


public interface DoctorService extends BaseService<Doctor> {

    List<Doctor> findByClinic(Clinic clinic);
    Doctor findDoctorById(Long id);

    List<Doctor> findAllDoctor();

    Doctor findByUserId(UserAccount user);
}
