package taha.clinic.service.Person.impl;

import taha.clinic.base.service.impl.BaseServiceImpl;
import taha.clinic.entity.Person;
import taha.clinic.repository.person.PersonRepo;
import taha.clinic.repository.person.impl.PersonRepoImpl;
import taha.clinic.service.Person.PersonService;

import java.util.Optional;

public class PersonServiceImpl extends BaseServiceImpl<Person, PersonRepo> implements PersonService {
//    private final PersonRepo personRepo = new PersonRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager());

    public PersonServiceImpl(PersonRepoImpl repo) {
        super(repo);
    }

    @Override
    public Optional<Person> findPersonByNationalCode(Long nationalCode) {
        try {
            return repository.findPersonByNationalCode(nationalCode);
        } catch (Exception e) {
            return Optional.empty();
        }

//    public Optional<Person> findPerson(String firstName, String lastName){
//        try {
//            return personRepo.findPerson(firstName,lastName);
//        }catch (Exception e){
//            return Optional.empty();
//        }
//    }

//    public Optional<Person> findPerson(String username, String password) {
//        try {
//            return personRepo.findPerson(username, password);
//        } catch (Exception e) {
//            return Optional.empty();
//        }
//    }
    }
}
