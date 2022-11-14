package taha.readFile.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import taha.readFile.base.entity.BaseEntity;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
public class StudentCourseRating extends BaseEntity implements Serializable {

    private Double rate;
    private String description;
    @ManyToOne
    @MapsId("studentId")
    private Student student;
    @ManyToOne
    @MapsId("courseId")
    private Course course;

}
