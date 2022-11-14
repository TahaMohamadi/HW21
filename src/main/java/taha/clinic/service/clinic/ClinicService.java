package taha.clinic.service.clinic;

import taha.clinic.base.service.BaseService;
import taha.clinic.entity.Clinic;

import java.util.List;

public interface ClinicService extends BaseService<Clinic> {
    List<Clinic> findAllClinics();
     Clinic findByClinicId(Long id);
}
