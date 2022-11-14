package taha.clinic.service.Person;

import taha.clinic.base.service.BaseService;
import taha.clinic.entity.Person;

import java.util.Optional;

public interface PersonService extends BaseService<Person> {
    Optional<Person> findPersonByNationalCode(Long nationalCode);
//    Optional<Person> findPerson(String username, String password);

}
