package taha.clinic.menu;

import taha.clinic.entity.Doctor;
import taha.clinic.entity.Patient;
import taha.clinic.entity.UserAccount;
import taha.clinic.operation.AppointmentOperation;
import taha.clinic.operation.PrescriptionOperation;
import taha.clinic.repository.appointment.impl.AppointmentRepoImpl;
import taha.clinic.repository.doctor.Impl.DoctorRepoImpl;
import taha.clinic.repository.patient.impl.PatientRepoImpl;
import taha.clinic.repository.prescription.impl.PrescriptionRepoImpl;
import taha.clinic.service.appointment.AppointmentService;
import taha.clinic.service.appointment.impl.AppointmentServiceImpl;
import taha.clinic.service.doctor.DoctorService;
import taha.clinic.service.doctor.impl.DoctorServiceImpl;
import taha.clinic.service.patient.PatientService;
import taha.clinic.service.patient.impl.PatientServiceImpl;
import taha.clinic.service.prescription.PrescriptionService;
import taha.clinic.service.prescription.impl.PrescriptionServiceImpl;
import taha.clinic.util.Hibernate;

import java.sql.*;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class DoctorMenu {

    private final Scanner scanner = new Scanner(System.in);
    private  final DoctorService doctorService = new DoctorServiceImpl(new DoctorRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final PatientService patientService = new PatientServiceImpl(new PatientRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    private final AppointmentService appointmentService = new AppointmentServiceImpl(new AppointmentRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    AppointmentOperation appointmentOperation = new AppointmentOperation();
    private final PrescriptionService prescriptionService = new PrescriptionServiceImpl(new PrescriptionRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    PrescriptionOperation prescriptionOperation = new PrescriptionOperation();

    public void showAllDoctors() {
        System.out.println("doctor list: ");
        List<Doctor> doctors = doctorService.findAllDoctor();
        AtomicInteger count = new AtomicInteger();
        doctors.forEach(doctor-> {
        count.getAndIncrement();
        System.out.println(count + ". " + "doctor id: " + doctor.getId() +"  ----  " + doctor.getPerson().getFirstName() + " " + doctor.getPerson().getLastName() + "  ----  clinic: " + doctor.getClinic().getName());
        });
        Long doctorId = scanner.nextLong();
        AppointmentMenu appointmentMenu = new AppointmentMenu();
        appointmentMenu.showAllAppointment(doctorId);
    }

    public void showMenu(List<Doctor> doctors, UserAccount userAccount) {
        while (true) {
            System.out.println("choose your doctor's code for take an Appointment: ");
            AtomicInteger i = new AtomicInteger(1);
            doctors.forEach(doctor -> {

                System.out.println( i.getAndAdd(1) + ". " + doctor.getPerson().getFirstName() +" "+ doctor.getPerson().getLastName() + "  ->  " + doctor.getSpeciality() + "   code: " + doctor.getId());
            });
            Long id = scanner.nextLong();
            AppointmentMenu appointmentMenu = new AppointmentMenu();
            appointmentMenu.showMenu(id, userAccount, doctors);
        }
    }

    private void takeAppointment(Long id, UserAccount userAccount){
        Doctor doctor = doctorService.findById(id).get();
        Patient patient = patientService.findById(userAccount.getId()).get();
        // doesn't have validation
        while (true) {
            System.out.println("choose your year: ");
            int year = scanner.nextInt();
            System.out.println("choose your month: ");
            int month = scanner.nextInt();
            System.out.println("choose your day: ");
            int day = scanner.nextInt();
            Date date = new Date(year, month - 1, day);
            System.out.println("choose your day: ");
            System.out.println("choose your start time: ");
            System.out.println("hour: ");
            int hour = scanner.nextInt();
            System.out.println("minute: ");
            int minute = scanner.nextInt();
            Time fromTime = new Time(hour, minute, 0);
            System.out.println("choose your end time: ");
            System.out.println("hour: ");
            hour = scanner.nextInt();
            System.out.println("minute: ");
            minute = scanner.nextInt();
            Time thruTime = new Time(hour, minute, 0);

        }
    }

    public void showDoctorMenu(UserAccount user) {
        System.out.println("welcome doctor");
        System.out.println("your appointment is: ");
        appointmentOperation.doctorAppointment(user);
        System.out.println("select your appointment id: ");
        Long id = scanner.nextLong();
        PrescriptionMenu prescriptionMenu = new PrescriptionMenu();
        prescriptionMenu.createPrescription(id);
    }


}

