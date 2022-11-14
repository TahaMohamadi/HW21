package taha.clinic.repository.secretary.impl;

import taha.clinic.base.repository.impl.BaseRepositoryImpl;
import taha.clinic.entity.Secretary;
import jakarta.persistence.EntityManager;
import taha.clinic.repository.secretary.SecretaryRepo;

public class SecretaryRepoImpl extends BaseRepositoryImpl<Secretary> implements SecretaryRepo {

    public SecretaryRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Secretary> getEntityClass() {
        return Secretary.class;
    }
}
