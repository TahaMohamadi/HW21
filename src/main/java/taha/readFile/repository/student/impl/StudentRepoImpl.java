package taha.readFile.repository.student.impl;

import jakarta.persistence.EntityManager;
import taha.readFile.base.repository.impl.BaseRepositoryImpl;
import taha.readFile.entity.Course;
import taha.readFile.entity.Student;
import taha.readFile.repository.student.StudentRepo;

public class StudentRepoImpl extends BaseRepositoryImpl<Student> implements StudentRepo {
    public StudentRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }
}
