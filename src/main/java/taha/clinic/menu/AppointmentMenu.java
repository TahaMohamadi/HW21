package taha.clinic.menu;

import taha.clinic.entity.Appointment;
import taha.clinic.entity.Doctor;
import taha.clinic.entity.Patient;
import taha.clinic.entity.UserAccount;
import taha.clinic.operation.AppointmentOperation;
import taha.clinic.repository.doctor.Impl.DoctorRepoImpl;
import taha.clinic.repository.patient.impl.PatientRepoImpl;
import taha.clinic.service.doctor.DoctorService;
import taha.clinic.service.doctor.impl.DoctorServiceImpl;
import taha.clinic.service.patient.PatientService;
import taha.clinic.service.patient.impl.PatientServiceImpl;
import taha.clinic.util.Hibernate;

import java.util.List;
import java.util.Scanner;

public class AppointmentMenu {
    private final DoctorService doctorService = new DoctorServiceImpl(new DoctorRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final PatientService patientService = new PatientServiceImpl(new PatientRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    AppointmentOperation appointmentOperation = new AppointmentOperation();
    Scanner scanner = new Scanner(System.in);
    public void showMenu(Long id, UserAccount userAccount, List<Doctor> doctors) {
        Patient patient = patientService.findByUserAccount(userAccount);
        Doctor doctor = doctorService.findDoctorById(id);


            System.out.println("enter your year");
            int year = scanner.nextInt();

            System.out.println("enter your month");
            int month = scanner.nextInt();

            System.out.println("enter your day");
            int day = scanner.nextInt();

            System.out.println("enter your hour");
            int hour = scanner.nextInt();
            System.out.println("enter your minute");
            int minute = scanner.nextInt();
            appointmentOperation.takeAppointment(patient,doctor, year, month, day, hour, minute, userAccount, doctors);
            PatientMenu patientMenu = new PatientMenu();
            patientMenu.showMenu(userAccount);




    }

    public void showAllAppointment(Long doctorId) {
        System.out.println("all appointment of this doctor: ");
        List<Appointment> appointments= appointmentOperation.showAllAppointment(doctorId);
    }

    public void showAllAppointments() {
        System.out.println("all appointment of Hospital");
        List<Appointment> appointments= appointmentOperation.showAllAppointments();
    }
}




