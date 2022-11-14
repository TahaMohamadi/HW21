package taha.clinic.repository.person;

import taha.clinic.base.repository.BaseRepository;
import taha.clinic.entity.Person;

import java.util.Optional;

public interface PersonRepo extends BaseRepository<Person> {
    Optional<Person> findPerson(String username, String password);

    Optional<Person> findPersonByNationalCode(Long nationalCode);
}
