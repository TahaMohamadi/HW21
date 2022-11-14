package taha.clinic.repository.medicalRecord.impl;

import taha.clinic.base.repository.impl.BaseRepositoryImpl;
import taha.clinic.entity.MedicalRecord;
import taha.clinic.entity.Patient;
import jakarta.persistence.EntityManager;
import taha.clinic.repository.medicalRecord.MedicalRecordRepo;
import taha.clinic.util.Hibernate;

public class MedicalRecordRepoImpl extends BaseRepositoryImpl<MedicalRecord> implements MedicalRecordRepo {
    public MedicalRecordRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<MedicalRecord> getEntityClass() {
        return MedicalRecord.class;
    }

    @Override
    public MedicalRecord findByPatient(Patient patient) {
        String jpql = """
                select m from MedicalRecord m where m.patient = :patient
                """;
        return (Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, MedicalRecord.class)
                .setParameter("patient", patient).getSingleResult());
            }
}


