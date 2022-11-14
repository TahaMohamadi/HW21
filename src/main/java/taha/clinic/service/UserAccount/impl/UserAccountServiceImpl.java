package taha.clinic.service.UserAccount.impl;

import taha.clinic.base.service.impl.BaseServiceImpl;
import taha.clinic.entity.UserAccount;
import taha.clinic.repository.userAccount.UserAccountRepo;
import taha.clinic.repository.userAccount.UserAccountRepoImpl;
import taha.clinic.service.UserAccount.UserAccountService;

import java.util.Optional;

public class UserAccountServiceImpl extends BaseServiceImpl<UserAccount, UserAccountRepo> implements UserAccountService {


    public UserAccountServiceImpl(UserAccountRepoImpl repository) {
        super(repository);
    }


    public Optional<UserAccount> findUserAccount(String username, String password) {
        try {
            return repository.findUserAccount(username, password);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<UserAccount> findUserAccount(String username) {
        try {
            return repository.findUserAccount(username);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
