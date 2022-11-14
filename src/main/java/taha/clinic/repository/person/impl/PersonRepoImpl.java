package taha.clinic.repository.person.impl;

import taha.clinic.base.repository.impl.BaseRepositoryImpl;
import taha.clinic.entity.Person;
import jakarta.persistence.EntityManager;
import taha.clinic.repository.person.PersonRepo;
import taha.clinic.util.Hibernate;

import java.util.Optional;

public class PersonRepoImpl extends BaseRepositoryImpl<Person> implements PersonRepo {

    public PersonRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Person> getEntityClass() {
        return Person.class;
    }

    @Override
    public Optional<Person> findPerson(String firstName, String lastname) {
        String jpql = """
                select p from Person p where p.firstName = :username and p.lastName = :lastname
                """;
        return Optional.ofNullable(Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Person.class)
                .setParameter("firstName", firstName).setParameter("lastname",lastname).getSingleResult());
    }

    @Override
    public Optional<Person> findPersonByNationalCode(Long nationalCode) {
        String jpql = """
                select p from Person p where p.nationalCode = :nationalCode
                """;
        return Optional.ofNullable(Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Person.class)
                .setParameter("nationalCode", nationalCode).getSingleResult());
    }
}
