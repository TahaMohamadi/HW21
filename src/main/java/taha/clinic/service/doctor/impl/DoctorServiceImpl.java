package taha.clinic.service.doctor.impl;

import taha.clinic.base.service.impl.BaseServiceImpl;
import taha.clinic.entity.Clinic;
import taha.clinic.entity.Doctor;
import taha.clinic.entity.UserAccount;
import taha.clinic.repository.doctor.DoctorRepo;
import taha.clinic.service.doctor.DoctorService;

import java.util.List;

public class DoctorServiceImpl extends BaseServiceImpl<Doctor, DoctorRepo> implements DoctorService {

    public DoctorServiceImpl(DoctorRepo repository) {
        super(repository);
    }


    @Override
    public List<Doctor> findByClinic(Clinic clinic) {
        try{
            return repository.findByClinic(clinic);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Doctor findDoctorById(Long id) {
        try{
            return repository.findDoctorById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Doctor> findAllDoctor() {
        try{
            return repository.findAllDoctor();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Doctor findByUserId(UserAccount user) {
        try{
            return repository.findByUserId(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
