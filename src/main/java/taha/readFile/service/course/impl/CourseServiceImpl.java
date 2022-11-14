package taha.readFile.service.course.impl;

import taha.readFile.base.service.impl.BaseServiceImpl;
import taha.readFile.entity.Course;
import taha.readFile.repository.course.CourseRepo;
import taha.readFile.service.course.CourseService;

public class CourseServiceImpl extends BaseServiceImpl<Course, CourseRepo> implements CourseService {

    public CourseServiceImpl(CourseRepo repository) {
        super(repository);
    }
}
