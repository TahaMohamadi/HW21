package taha.clinic.repository.patient.impl;

import taha.clinic.base.repository.impl.BaseRepositoryImpl;
import taha.clinic.entity.MedicalRecord;
import taha.clinic.entity.Patient;
import taha.clinic.entity.UserAccount;
import jakarta.persistence.EntityManager;
import taha.clinic.repository.patient.PatientRepo;
import taha.clinic.util.Hibernate;

import java.util.List;

public class PatientRepoImpl extends BaseRepositoryImpl<Patient> implements PatientRepo {
    public PatientRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Patient> getEntityClass() {
        return Patient.class;
    }

    @Override
    public Patient findByUserAccount(UserAccount userAccount) {
        String jpql = """
                select p from Patient p where p.userAccount = :userAccount
                """;
        return (Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Patient.class)
                .setParameter("userAccount", userAccount).getSingleResult());
    }

    @Override
    public Patient findByMedicalRecord(MedicalRecord medicalRecord) {
        String jpql = """
                select p from Patient p where p.medicalRecord = :medicalRecord
                """;
        return (Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Patient.class)
                .setParameter("medicalRecord", medicalRecord).getSingleResult());
    }

    @Override
    public List<Patient> findAllPatient() {
        String jpql = """
                select p from Patient p 
                """;
        return (Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Patient.class)
                .getResultList());
    }

    @Override
    public Patient patientDesc(Long patientId) {
        String jpql = """
                select p from Patient p where p.id = :patientId
                """;
        return (Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Patient.class).setParameter("patientId",patientId)
                .getSingleResult());
    }


}
