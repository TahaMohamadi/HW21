package taha.clinic.service.secretary.impl;

import taha.clinic.base.service.impl.BaseServiceImpl;
import taha.clinic.entity.Secretary;
import taha.clinic.repository.secretary.SecretaryRepo;
import taha.clinic.service.secretary.SecretaryService;

public class
SecretaryServiceImpl extends BaseServiceImpl<Secretary, SecretaryRepo> implements SecretaryService {

    public SecretaryServiceImpl(SecretaryRepo repository) {
        super(repository);
    }
}
