package taha.clinic.operation;

import taha.clinic.entity.MedicalRecord;
import taha.clinic.entity.Patient;
import taha.clinic.entity.Person;
import taha.clinic.entity.UserAccount;
import taha.clinic.entity.enums.AccountType;
import taha.clinic.menu.DoctorMenu;
import taha.clinic.menu.Home;
import taha.clinic.menu.PatientMenu;
import taha.clinic.menu.SecretaryMenu;
import taha.clinic.repository.medicalRecord.impl.MedicalRecordRepoImpl;
import taha.clinic.repository.patient.impl.PatientRepoImpl;
import taha.clinic.repository.person.impl.PersonRepoImpl;
import taha.clinic.repository.userAccount.UserAccountRepoImpl;
import taha.clinic.service.Person.PersonService;
import taha.clinic.service.Person.impl.PersonServiceImpl;
import taha.clinic.service.UserAccount.UserAccountService;
import taha.clinic.service.UserAccount.impl.UserAccountServiceImpl;
import taha.clinic.service.medicalRecord.MedicalRecordService;
import taha.clinic.service.medicalRecord.impl.MedicalRecordServiceImpl;
import taha.clinic.service.patient.PatientService;
import taha.clinic.service.patient.impl.PatientServiceImpl;
import taha.clinic.util.Hibernate;

import java.util.Optional;
import java.util.Scanner;

public class Validation {
    private final Scanner scanner = new Scanner(System.in);
    PersonService personService = new PersonServiceImpl(new PersonRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    UserAccountService userAccountService= new UserAccountServiceImpl(new UserAccountRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    MedicalRecordService medicalRecordService = new MedicalRecordServiceImpl(new MedicalRecordRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
    PatientService patientService = new PatientServiceImpl(new PatientRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));

    public void loginMenu() {

        System.out.println("Enter your username: ");
        String username = validName(scanner.next());
        System.out.println("Enter your password: ");
        String password = validName(scanner.next());
        Optional<UserAccount> optionalUserAccount = userAccountService.findUserAccount(username, password);
//        UserAccount userAccount = userAccountService.findUserAccount(username, password);
        System.out.println("w ");

        optionalUserAccount.ifPresentOrElse(user -> {
            if(optionalUserAccount.get().getAccountType() == AccountType.DOCTOR) {
              DoctorMenu doctorMenu = new DoctorMenu();
              doctorMenu.showDoctorMenu(user);
            } else if (optionalUserAccount.get().getAccountType() == AccountType.PATIENT) {
                PatientMenu patientMenu = new PatientMenu();
                patientMenu.showMenu(user);
            } else if (optionalUserAccount.get().getAccountType() == AccountType.SECRETARY) {
                SecretaryMenu secretaryMenu = new SecretaryMenu();
                secretaryMenu.showMenu(user);
            } else {
                Home home = new Home();
                home.showMenu();

            };

        }, () -> System.out.println("username or password is wrong"));


    }

    private String validName(String name) {
        boolean check;
        while (true) {
            if (name.length() < 2 || name.length() > 20) {
                System.out.print("Name must between 2 and 20 character. Enter again: ");
                name = scanner.next();
                continue;
            }
            check = false;
            for (Character character : name.toCharArray()) {
                if (Character.isDigit(character)) {
                    System.out.print("Name cant have number. Enter again: ");
                    name = scanner.next();
                    check = true;
                    break;
                }
            }
            if (!check) return name;
        }
    }

    public void signupMenu() {
        System.out.println("Enter your firstname: ");
        String firstname = validName(scanner.next());
        System.out.println("Enter your lastname: ");
        String lastname = validName(scanner.next());
        System.out.println("Enter your nationalCode: ");
        Long nationalCode = checkExistNationalCode(scanner.nextLong());
//        Long nationalCode = scanner.nextLong();
        Person person = new Person(firstname, lastname, nationalCode);
        System.out.println("Enter your username: ");
        String username = checkExistUsername(validName(scanner.next()));
        System.out.println("Enter your password: ");
        String password = scanner.next();
        System.out.println("1. Doctor ");
        System.out.println("2. Patient ");
        System.out.println("3. Secretary ");
        int accountTypeNum = scanner.nextInt();
        AccountType accountType = null;
        boolean a = true;

        while (a) {
            if (accountTypeNum == 1) {
                accountType = AccountType.DOCTOR;
                a = false;
            } else if (accountTypeNum == 2) {
                accountType = AccountType.PATIENT;
                a = false;

            } else if (accountTypeNum == 3) {
                accountType = AccountType.SECRETARY;
                a = false;
            } else {
                System.out.println("choose between 1, 2, 3");
            }
        }
        personService.save(person);

        UserAccount userAccount = new UserAccount(username, password, accountType, person);
        userAccountService.save(userAccount);

        if (accountType == AccountType.PATIENT){
            Patient patient = new Patient(null, userAccount);
            MedicalRecord medicalRecord = new MedicalRecord(patient, null, null);
//            patient.setMedicalRecord(medicalRecord);
            patientService.save(patient);
            medicalRecordService.save(medicalRecord);
        }


        if (accountType == AccountType.PATIENT) {
            PatientMenu patientMenu = new PatientMenu();
            patientMenu.showMenu(userAccount);
        } else if (accountType == AccountType.DOCTOR) {
            DoctorMenu doctorMenu = new DoctorMenu();
            doctorMenu.showDoctorMenu(userAccount);
        } else if (accountType == AccountType.SECRETARY) {
            SecretaryMenu secretaryMenu =new SecretaryMenu();
            secretaryMenu.showMenu(userAccount);
        }
    }


    private String checkExistUsername(String username) {
        while (true) {
            Optional<UserAccount> optionalUser = userAccountService.findUserAccount(username);
            if (optionalUser.isPresent()) {
                System.out.print("This username is taken. try another one: ");
                username = scanner.next();
            } else {
                return username;
            }
        }
    }

    private Long checkExistNationalCode(Long nationalCode) {
        boolean a = true;
        while (a){
            PersonService personService = new PersonServiceImpl(new PersonRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
            Optional<Person> optionalPersons = personService.findPersonByNationalCode(nationalCode);
            if (optionalPersons.isPresent()) {
                System.out.print("This nationalCode is exist. try another again: ");
                nationalCode = scanner.nextLong();
            } else {
                a = false;
                return nationalCode;
            }
        }
        return nationalCode;

    }

}
