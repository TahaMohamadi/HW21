package taha.clinic.service.drug;

import taha.clinic.base.service.BaseService;
import taha.clinic.entity.Drug;

public interface DrugService extends BaseService<Drug> {
    Drug findByName(String name);
}
