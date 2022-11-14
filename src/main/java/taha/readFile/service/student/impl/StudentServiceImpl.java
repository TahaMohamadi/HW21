package taha.readFile.service.student.impl;

import taha.readFile.base.service.impl.BaseServiceImpl;
import taha.readFile.entity.Course;
import taha.readFile.entity.Student;
import taha.readFile.repository.course.CourseRepo;
import taha.readFile.repository.student.StudentRepo;
import taha.readFile.service.course.CourseService;
import taha.readFile.service.student.StudentService;

public class StudentServiceImpl extends BaseServiceImpl<Student, StudentRepo> implements StudentService {
    public StudentServiceImpl(StudentRepo repository) {
        super(repository);
    }
}
