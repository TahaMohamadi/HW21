package taha.clinic.service.appointment.impl;

import taha.clinic.base.service.impl.BaseServiceImpl;
import taha.clinic.entity.Appointment;
import taha.clinic.entity.Doctor;
import taha.clinic.entity.Patient;
import taha.clinic.repository.appointment.AppointmentRepo;
import taha.clinic.service.appointment.AppointmentService;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class AppointmentServiceImpl extends BaseServiceImpl<Appointment, AppointmentRepo> implements AppointmentService {

    public AppointmentServiceImpl(AppointmentRepo repository) {
        super(repository);
    }

    @Override
    public List<Appointment> findByPatient(Patient patient) {
        try{
            return repository.findByPatient(patient);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public boolean checkAvailable(Doctor doctor, Time fromTime, Time thruTime, Date date) {
        try{
            return repository.checkAvailable(doctor, fromTime, thruTime, date);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Appointment> showAllAppointment(Long doctorId) {
        try{
            return repository.showAllAppointment(doctorId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Appointment> showAllAppointments() {
        try{
            return repository.showAllAppointments();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Appointment> finByDoctor(Doctor doctor) {
        try{
            return repository.finByDoctor(doctor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }    }
}
