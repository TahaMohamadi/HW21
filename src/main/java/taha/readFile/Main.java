package taha.readFile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import taha.readFile.entity.Course;
import taha.readFile.entity.Student;
import taha.readFile.entity.StudentCourseRating;
import taha.readFile.repository.StudentCourseRating.StudentCourseRatingRepo;
import taha.readFile.repository.StudentCourseRating.impl.StudentCourseRatingRepoImpl;
import taha.readFile.repository.course.impl.CourseRepoImpl;
import taha.readFile.repository.student.StudentRepo;
import taha.readFile.repository.student.impl.StudentRepoImpl;
import taha.readFile.service.StudentCourseRating.StudentCourseRatingService;
import taha.readFile.service.StudentCourseRating.impl.StudentCourseRatingServiceImpl;
import taha.readFile.service.course.CourseService;
import taha.readFile.service.course.impl.CourseServiceImpl;
import taha.readFile.service.student.StudentService;
import taha.readFile.service.student.impl.StudentServiceImpl;
import taha.readFile.util.Hibernate;
import jakarta.persistence.EntityManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws IOException {
        logger.warn("aaaaaaaaaaaaa");

        EntityManager em = Hibernate.getEntityManagerFactory().createEntityManager();
        CourseService courseService = new CourseServiceImpl(new CourseRepoImpl(em));
        StudentService studentService = new StudentServiceImpl(new StudentRepoImpl(em) );
        StudentCourseRatingService studentCourseRatingService = new StudentCourseRatingServiceImpl(new StudentCourseRatingRepoImpl(em)) ;

        FileReader fileReader = new FileReader("information.txt");
        logger.warn(fileReader.ready() +" : ddddddddd");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        logger.warn(bufferedReader +" : ssssssss");
        while (bufferedReader.ready()) {
            String[] objects = bufferedReader.readLine().split(",");
            logger.warn(Arrays.stream(objects).toList() + " : mmmmmmm");
            logger.warn(objects.toString() +" : yyyyyyyyy");
            Course course = new Course();
            Student student = new Student();
            StudentCourseRating studentCourseRating = new StudentCourseRating();

            course.setName(objects[0].replaceAll("\"",""));
            logger.warn(course +" : course");
            List<Course> courses = courseService.findByName();
            if(!courses.contains(courses)){
                courseService.save(course);
            }
            student.setName(objects[1]);
            List<Student> students = studentService.findAll();
            if (!students.contains(student)){
                studentService.save(student);
            }
            List<StudentCourseRating> studentCourseRatings = studentCourseRatingService.findAll();

            studentCourseRating.setTimestamp(Timestamp.valueOf(objects[2]));
            studentCourseRating.setRate(Double.valueOf(objects[3]));
            studentCourseRating.setStudent(student);
            studentCourseRating.setCourse(course);
            if (!studentCourseRatings.contains(studentCourseRating)){
                studentCourseRatingService.save(studentCourseRating);
            }

        }

    }

}
