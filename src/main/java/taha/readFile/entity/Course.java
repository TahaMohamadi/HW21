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
public class Course extends BaseEntity implements Serializable {

    private String name;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<StudentCourse> students = new ArrayList<>();
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<StudentCourseRating> studentCourseRatings = new ArrayList<>();

}
