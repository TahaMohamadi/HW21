package taha.clinic.repository.clinic;

import taha.clinic.base.repository.BaseRepository;
import taha.clinic.entity.Clinic;

import java.util.List;

public interface ClinicRepo extends BaseRepository<Clinic> {
      List<Clinic> findAllClinics();

      Clinic findClinicById(Long id);
}
