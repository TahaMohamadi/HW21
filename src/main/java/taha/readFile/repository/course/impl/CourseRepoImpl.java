package taha.readFile.repository.course.impl;

import jakarta.persistence.EntityManager;
import taha.readFile.base.repository.BaseRepository;
import taha.readFile.base.repository.impl.BaseRepositoryImpl;
import taha.readFile.entity.Course;
import taha.readFile.repository.course.CourseRepo;

public class CourseRepoImpl extends BaseRepositoryImpl<Course> implements CourseRepo {
    public CourseRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Course> getEntityClass() {
        return Course.class;
    }
}
