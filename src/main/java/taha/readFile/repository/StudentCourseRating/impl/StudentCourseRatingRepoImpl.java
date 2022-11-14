package taha.readFile.repository.StudentCourseRating.impl;

import jakarta.persistence.EntityManager;
import taha.readFile.base.repository.impl.BaseRepositoryImpl;

import taha.readFile.entity.StudentCourseRating;
import taha.readFile.repository.StudentCourseRating.StudentCourseRatingRepo;


public class StudentCourseRatingRepoImpl extends BaseRepositoryImpl<StudentCourseRating> implements StudentCourseRatingRepo {
    @Override
    public Class<StudentCourseRating> getEntityClass() {
        return StudentCourseRating.class;
    }

    public StudentCourseRatingRepoImpl(EntityManager em) {
        super(em);
    }
}
