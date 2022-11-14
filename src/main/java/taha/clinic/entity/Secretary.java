package taha.clinic.entity;

import taha.clinic.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Secretary extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;
}
