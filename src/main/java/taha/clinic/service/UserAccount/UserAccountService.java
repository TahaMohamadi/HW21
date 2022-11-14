package taha.clinic.service.UserAccount;

import taha.clinic.base.service.BaseService;
import taha.clinic.entity.UserAccount;

import java.util.Optional;

public interface UserAccountService extends BaseService<UserAccount> {
    Optional<UserAccount> findUserAccount(String username, String password);
    Optional<UserAccount> findUserAccount(String username);

}
