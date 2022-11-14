package taha.clinic.repository.drug;

import taha.clinic.base.repository.BaseRepository;
import taha.clinic.entity.Drug;

public interface DrugRepo extends BaseRepository<Drug> {
    Drug findByName(String name);
}
