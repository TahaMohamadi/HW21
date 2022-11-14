package taha.readFile.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import taha.readFile.base.entity.BaseEntity;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class StudentCourse extends BaseEntity implements Serializable {

    @ManyToOne
    @MapsId("studentId")
    private Student student;
    @ManyToOne
    @MapsId("courseId")
    private Course course;

}
