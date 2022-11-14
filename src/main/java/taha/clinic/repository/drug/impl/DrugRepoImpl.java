package taha.clinic.repository.drug.impl;

import taha.clinic.base.repository.impl.BaseRepositoryImpl;
import taha.clinic.entity.Drug;
import jakarta.persistence.EntityManager;
import taha.clinic.repository.drug.DrugRepo;
import taha.clinic.util.Hibernate;

public class DrugRepoImpl extends BaseRepositoryImpl<Drug> implements DrugRepo {
    public DrugRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Drug> getEntityClass() {
        return Drug.class;
    }
    @Override
    public Drug findByName(String name) {
        String jpql = """
                select d from Drug d where d.name = :name 
                """;
        return (Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Drug.class).setParameter("name", name).getSingleResult());

    }
}
