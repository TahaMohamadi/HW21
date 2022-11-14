package taha.clinic.service.drug.impl;

import taha.clinic.base.service.impl.BaseServiceImpl;
import taha.clinic.entity.Drug;
import taha.clinic.repository.drug.DrugRepo;
import taha.clinic.service.drug.DrugService;

public class DrugServiceImpl extends BaseServiceImpl<Drug, DrugRepo> implements DrugService {

    public DrugServiceImpl(DrugRepo repository) {
        super(repository);
    }
    @Override
    public Drug findByName(String name) {
        try{
            return repository.findByName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
