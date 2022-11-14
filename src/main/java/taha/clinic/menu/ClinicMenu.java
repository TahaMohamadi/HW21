package taha.clinic.menu;

import taha.clinic.entity.Doctor;
import taha.clinic.entity.UserAccount;
import taha.clinic.operation.ClinicOperation;
import taha.clinic.operation.DoctorOperation;

import java.util.List;
import java.util.Scanner;

public class ClinicMenu {
    private final Scanner scanner = new Scanner(System.in);
    public void showAll(UserAccount user) {

        ClinicOperation clinicOperation = new ClinicOperation();
        DoctorOperation doctorOperation = new DoctorOperation();
        while(true){
            System.out.println("Available Clinics: ");
            System.out.println("please select a Clinic");
            clinicOperation.showClinic();
            System.out.print("enter clinic id for see doctors of that clinic: ");
            Long id = scanner.nextLong();
            List<Doctor> doctors = doctorOperation.findByClinicId(id);
            DoctorMenu doctorMenu = new DoctorMenu();
            doctorMenu.showMenu(doctors, user);

        }
    }
}

