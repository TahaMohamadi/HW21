package taha.readFile.service.course;

import taha.readFile.base.service.BaseService;
import taha.readFile.entity.Course;

import java.util.List;

public interface CourseService extends BaseService<Course> {
    List<Course> findByName();
}
