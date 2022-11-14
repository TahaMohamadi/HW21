package taha.clinic.service.hospital.impl;

import taha.clinic.base.service.impl.BaseServiceImpl;
import taha.clinic.entity.Hospital;
import taha.clinic.repository.hospital.HospitalRepo;
import taha.clinic.service.hospital.HospitalService;

public class HospitalServiceImpl extends BaseServiceImpl<Hospital, HospitalRepo> implements HospitalService {

    public HospitalServiceImpl(HospitalRepo repository) {
        super(repository);
    }
}
