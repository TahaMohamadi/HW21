package taha.readFile.service.StudentCourseRating.impl;

import taha.readFile.base.service.impl.BaseServiceImpl;
import taha.readFile.entity.Student;
import taha.readFile.entity.StudentCourseRating;
import taha.readFile.repository.StudentCourseRating.StudentCourseRatingRepo;
import taha.readFile.repository.student.StudentRepo;
import taha.readFile.service.StudentCourseRating.StudentCourseRatingService;
import taha.readFile.service.student.StudentService;


public class StudentCourseRatingServiceImpl extends BaseServiceImpl<StudentCourseRating, StudentCourseRatingRepo> implements StudentCourseRatingService {

    public StudentCourseRatingServiceImpl(StudentCourseRatingRepo repository) {
        super(repository);
    }
}
