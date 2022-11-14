package taha.readFile.base.repository;


import jakarta.persistence.EntityManager;
import taha.readFile.base.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<E extends BaseEntity> {
    void save (E e);

    void update (E e);

    void delete (E e);

    Optional<E> findById (Long id);

    List<E> findAll();

    boolean isExistsById(Long id);

    Long countAll();

    EntityManager getEntityManager();
}