package taha.clinic.repository.prescription.impl;

import taha.clinic.base.repository.impl.BaseRepositoryImpl;
import taha.clinic.entity.Patient;
import taha.clinic.entity.Prescription;
import jakarta.persistence.EntityManager;
import taha.clinic.repository.prescription.PrescriptionRepo;
import taha.clinic.util.Hibernate;

import java.util.List;

public class PrescriptionRepoImpl extends BaseRepositoryImpl<Prescription> implements PrescriptionRepo {
    public PrescriptionRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Prescription> getEntityClass() {
        return Prescription.class;
    }

    @Override
    public List<Prescription> findByPatient(Patient patient) {
        String jpql = """
                select p from Prescription p where p.patient = :patient
                """;
        return (Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Prescription.class).setParameter("patient", patient).getResultList());
    }
}
