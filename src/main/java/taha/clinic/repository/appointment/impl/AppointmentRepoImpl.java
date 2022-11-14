package taha.clinic.repository.appointment.impl;

import taha.clinic.base.repository.impl.BaseRepositoryImpl;
import taha.clinic.entity.Appointment;
import taha.clinic.entity.Doctor;
import taha.clinic.entity.Patient;
import jakarta.persistence.EntityManager;
import taha.clinic.repository.appointment.AppointmentRepo;
import taha.clinic.util.Hibernate;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class AppointmentRepoImpl extends BaseRepositoryImpl<Appointment> implements AppointmentRepo {
    public AppointmentRepoImpl(EntityManager em) {
        super(em);
    }

    public Class<Appointment> getEntityClass() {
        return Appointment.class;
    }

    @Override
    public List<Appointment> findByPatient(Patient patient) {
        String jpql = """
                select a from Appointment a where a.patient = :patient
                """;
        return (Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Appointment.class).setParameter("patient", patient).getResultList());
    }

    @Override
    public boolean checkAvailable(Doctor doctor, Time fromTime, Time thruTime, Date date) {
        String jpql = """
                select a from Appointment a where
                    a.doctor = :doctor 
                and a.date = :date
                and ((a.fromTime between :fromTime and :thruTime) or a.fromTime = :fromtime or (a.thruTime between :fromTime and :thruTime))
                """;
        List<Appointment> appointment = (Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Appointment.class)
                .setParameter("doctor",doctor )
                .setParameter("date",date )
                .setParameter("fromTime",fromTime )
                .setParameter("thruTime",thruTime )
        ).getResultList();
        boolean check;
        if (appointment.size() > 0) {
            check  = true;
        } else {
            check = false;
        }
        return check;
    }

    @Override
    public List<Appointment> showAllAppointment(Long doctorId) {
        String jpql = """
                select a from Appointment a where a.doctor.id = :doctorId
                """;
        return (Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Appointment.class).setParameter("doctorId", doctorId).getResultList());
    }

    @Override
    public List<Appointment> showAllAppointments() {
        String jpql = """
                select a from Appointment a
                """;
        return (Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Appointment.class).getResultList());
    }

    @Override
    public List<Appointment> finByDoctor(Doctor doctor) {
        String jpql = """
                select a from Appointment a where a.doctor = :doctor
                """;
        return (Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Appointment.class).setParameter("doctor", doctor).getResultList());
    }
}
