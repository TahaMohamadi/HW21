package taha.clinic.repository.hospital.impl;

import taha.clinic.base.repository.impl.BaseRepositoryImpl;
import taha.clinic.entity.Hospital;
import jakarta.persistence.EntityManager;
import taha.clinic.repository.hospital.HospitalRepo;

public class HospitalRepoImpl extends BaseRepositoryImpl<Hospital> implements HospitalRepo {
    public HospitalRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Hospital> getEntityClass() {
        return Hospital.class;
    }
}
