package taha.clinic.service.clinic.impl;

import taha.clinic.base.service.impl.BaseServiceImpl;
import taha.clinic.entity.Clinic;
import taha.clinic.repository.clinic.ClinicRepo;
import taha.clinic.service.clinic.ClinicService;

import java.util.List;

public class ClinicServiceImpl extends BaseServiceImpl<Clinic, ClinicRepo> implements ClinicService {

    public ClinicServiceImpl(ClinicRepo repository) {
        super(repository);
    }


    @Override
    public List<Clinic> findAllClinics() {
        try {
            repository.getEntityManager().getTransaction().begin();
            return repository.findAllClinics();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Clinic findByClinicId(Long id) {
        try {
            repository.getEntityManager().getTransaction().begin();
            return repository.findClinicById(id);
        } catch (Exception e) {
            return null;
        }
    }
}