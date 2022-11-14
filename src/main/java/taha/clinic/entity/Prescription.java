package taha.clinic.entity;

import taha.clinic.base.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Prescription  extends BaseEntity {
    @ManyToMany
    @JoinTable(name = "Prescription_drugs",
            joinColumns = @JoinColumn(name = "prescription_id"),
            inverseJoinColumns = @JoinColumn(name = "drugs_id"))
    private List<Drug> drugs = new ArrayList<>();
    @OneToOne
    private Patient patient;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "medical_record_id")
    private MedicalRecord medicalRecord;
    @OneToOne
    private Doctor doctor;
}
