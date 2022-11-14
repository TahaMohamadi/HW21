package taha.clinic.repository.doctor.Impl;

import taha.clinic.base.repository.impl.BaseRepositoryImpl;
import taha.clinic.entity.Clinic;
import taha.clinic.entity.Doctor;
import taha.clinic.entity.UserAccount;
import jakarta.persistence.EntityManager;
import taha.clinic.repository.doctor.DoctorRepo;
import taha.clinic.util.Hibernate;

import java.util.List;

public class DoctorRepoImpl extends BaseRepositoryImpl<Doctor> implements DoctorRepo {
    public DoctorRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Doctor> getEntityClass() {
        return Doctor.class;
    }

    @Override
    public List<Doctor> findByClinic(Clinic clinic) {
        String jpql = """
                select d from Doctor d where d.clinic = :clinic
                """;
        return (Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Doctor.class).setParameter("clinic", clinic).getResultList());
    }

    @Override
    public Doctor findDoctorById(Long id) {
        String jpql = """
                select d from Doctor d where d.id = :id
                """;
        return (Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Doctor.class).setParameter("id", id).getSingleResult());
    }

    @Override
    public List<Doctor> findAllDoctor() {
        String jpql = """
                select d from Doctor d 
                """;
        return (Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Doctor.class).getResultList());
    }
    @Override
    public Doctor findByUserId(UserAccount user) {
        String jpql = """
                select d from Doctor d where d.userAccount = :user
                """;
        return (Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Doctor.class).setParameter("user", user).getSingleResult());
    }
}

