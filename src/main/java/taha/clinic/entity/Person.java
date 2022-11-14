package taha.clinic.entity;

import taha.clinic.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Person extends BaseEntity {
    private String firstName;
    private String lastName;
    private Long nationalCode;

}
