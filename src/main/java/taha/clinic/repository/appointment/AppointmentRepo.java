package taha.clinic.repository.appointment;

import taha.clinic.base.repository.BaseRepository;
import taha.clinic.entity.Appointment;
import taha.clinic.entity.Doctor;
import taha.clinic.entity.Patient;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface AppointmentRepo extends BaseRepository<Appointment> {
    List<Appointment> findByPatient(Patient patient);

    boolean checkAvailable(Doctor doctor, Time fromTime, Time thruTime, Date date);

    List<Appointment> showAllAppointment(Long doctorId);

    List<Appointment> showAllAppointments();

    List<Appointment> finByDoctor(Doctor doctor);
}
