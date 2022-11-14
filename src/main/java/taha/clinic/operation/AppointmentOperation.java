package taha.clinic.operation;

import taha.clinic.entity.enums.AppointmentType;
import taha.clinic.menu.AppointmentMenu;
import taha.clinic.menu.PatientMenu;
import taha.clinic.repository.appointment.impl.AppointmentRepoImpl;
import taha.clinic.repository.doctor.Impl.DoctorRepoImpl;
import taha.clinic.repository.medicalRecord.impl.MedicalRecordRepoImpl;
import taha.clinic.repository.patient.impl.PatientRepoImpl;
import taha.clinic.service.appointment.AppointmentService;
import taha.clinic.service.appointment.impl.AppointmentServiceImpl;
import taha.clinic.service.doctor.DoctorService;
import taha.clinic.service.doctor.impl.DoctorServiceImpl;
import taha.clinic.service.medicalRecord.MedicalRecordService;
import taha.clinic.service.medicalRecord.impl.MedicalRecordServiceImpl;
import taha.clinic.service.patient.PatientService;
import taha.clinic.service.patient.impl.PatientServiceImpl;
import taha.clinic.util.Hibernate;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AppointmentOperation {
    private final AppointmentService appointmentService = new AppointmentServiceImpl(new AppointmentRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final PatientService patientService = new PatientServiceImpl(new PatientRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final MedicalRecordService medicalRecordService = new MedicalRecordServiceImpl(new MedicalRecordRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final DoctorService doctorService = new DoctorServiceImpl(new DoctorRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));

    public void showAll(MedicalRecord medicalRecord) {
        Patient patient = patientService.findByMedicalRecord(medicalRecord);
        List<Appointment> appointments = appointmentService.findByPatient(patient);
        appointments.forEach(appointment -> {
            System.out.println(appointment.getId() + "." + " doctor: " +appointment.getDoctor().getPerson().getFirstName() + " " + appointment.getDoctor().getPerson().getLastName());
            System.out.println("time from:" + appointment.getFromTime() + " to: " + appointment.getThruTime() +" in " +appointment.getDate());
        });
    }

//    public void showAll(MedicalRecord medicalRecord , Patient patient) {
//        List<MedicalRecord> medicalRecords = medicalRecordService.findByPatient(patient);
//        System.out.println("Your medicalRecord:");
//
//    }

    public void takeAppointment(Patient patient, Doctor doctor, int year, int month, int day, int hour, int minute, UserAccount userAccount, List<Doctor> doctors) {
        LocalTime time1 = LocalTime.of(hour,minute);
        System.out.println("your from time is: " + time1.toString());
        Time fromTime = Time.valueOf(time1);
        System.out.println("your from time is: " + fromTime.toString());

        minute = minute +30;
        if (minute>59){
            hour++;
            minute = minute - 60;
        }
        if (hour > 24){
            day++;
            hour = - 24;
        }
        if (day > 30){
            month++;
            day = -30;
        }
        if(month > 12){
            year++;
            month= -12;
        }

        LocalTime thruTimes = LocalTime.of(hour, minute);
        LocalDate dates = LocalDate.of(year, month, day);
        Time thruTime = Time.valueOf(thruTimes);
        Date date = Date.valueOf(dates);

        boolean check = appointmentService.checkAvailable(doctor, fromTime, thruTime, date);
        if (check) {
            Appointment appointment = new Appointment(patient, doctor, fromTime, thruTime, date, AppointmentType.WAITING);
            appointmentService.save(appointment);

            System.out.println("Your appointment is set!");
            PatientMenu patientMenu = new PatientMenu();
            patientMenu.showMenu(userAccount);
        } else {
            System.out.println("this time is not available, try again");
            AppointmentMenu appointment = new AppointmentMenu();
            appointment.showMenu(doctor.getId(), userAccount, doctors);
        }

    }

    public List<Appointment> showAllAppointment(Long doctorId) {
        List<Appointment> appointments= appointmentService.showAllAppointment(doctorId);
        return appointments;
    }

    public List<Appointment> showAllAppointments() {
        List<Appointment> appointments= appointmentService.showAllAppointments();
        return appointments;
    }

    public void doctorAppointment(UserAccount user) {
        Doctor doctor = doctorService.findByUserId(user);

        List<Appointment> appointments = appointmentService.finByDoctor(doctor);
        AtomicInteger i = new AtomicInteger();
        appointments.forEach(appointment -> {
            i.getAndIncrement();
            System.out.println(i +". id: "+appointment.getId() +" | time: "+appointment.getFromTime() + " - " + appointment.getThruTime() + " | name: " + appointment.getPatient().getUserAccount().getPerson().getFirstName() +" " + appointment.getPatient().getUserAccount().getPerson().getLastName() );
        });
    }
}



