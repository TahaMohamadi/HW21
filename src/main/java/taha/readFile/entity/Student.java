package taha.readFile.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import taha.readFile.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Student extends BaseEntity implements Serializable {


    private String firstname;
    private String lastname;
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<StudentCourse> courses = new ArrayList<>();
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<StudentCourseRating> studentCourseRatings = new ArrayList<>();

}
