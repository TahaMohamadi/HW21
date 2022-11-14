package taha.clinic.menu;

import taha.clinic.entity.Patient;
import taha.clinic.entity.UserAccount;
import taha.clinic.operation.MedicalRecordOperation;
import taha.clinic.repository.patient.impl.PatientRepoImpl;
import taha.clinic.repository.userAccount.UserAccountRepoImpl;
import taha.clinic.service.UserAccount.UserAccountService;
import taha.clinic.service.UserAccount.impl.UserAccountServiceImpl;
import taha.clinic.service.patient.PatientService;
import taha.clinic.service.patient.impl.PatientServiceImpl;
import taha.clinic.util.Hibernate;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class PatientMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final PatientService patientService = new PatientServiceImpl(new PatientRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    UserAccountService userAccountService= new UserAccountServiceImpl(new UserAccountRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));

    public void showMenu(UserAccount user) {
        while (true) {
            System.out.println("Welcome "+ user.getUsername());
            System.out.println("please select your ir.TahaMohammadi.clinic.service number");
            System.out.println("1- show clinics");
            System.out.println("2- show medical record");
            System.out.println("3- settings");
            System.out.println("4- Exit");
            System.out.print("Enter your command: ");
            String patientCommand = scanner.next();
            if (Objects.equals(patientCommand, "1")) {
                ClinicMenu clinicMenu = new ClinicMenu();
                clinicMenu.showAll(user);
            } else if (Objects.equals(patientCommand, "2")) {
                MedicalRecordOperation medicalRecordOperation = new MedicalRecordOperation();
                medicalRecordOperation.showMedicalRecord(user);
            } else if ((Objects.equals(patientCommand, "3"))) {
                break;
            } else {
                System.out.println("Wrong command.");
            }

        }
    }

    public void showAllPatient() {
        System.out.println("list of all patient: ");
        List<Patient> patientList =  patientService.findAllPatient();
        AtomicInteger a = new AtomicInteger(0);
        patientList.forEach(patient -> {
            a.getAndIncrement();
            System.out.println(a + ". " + patient.getUserAccount().getPerson().getFirstName() +" "+ patient.getUserAccount().getPerson().getLastName() + " -> patient id: " + patient.getId());
            System.out.println("enter patient Id: ");

            Long patientId = scanner.nextLong();
        PatientMenu patientMenu = new PatientMenu();
        patientMenu.patientDesc(patientId);
        });
    }

    private void patientDesc(Long patientId) {
        Optional<Patient> patient = patientService.findById(patientId);
        MedicalRecordOperation medicalRecordOperation = new MedicalRecordOperation();
        medicalRecordOperation.showMedicalRecord(patient.get().getUserAccount());
    }
}
