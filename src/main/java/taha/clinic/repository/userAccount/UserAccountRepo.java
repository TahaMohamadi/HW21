package taha.clinic.repository.userAccount;

import taha.clinic.base.repository.BaseRepository;
import taha.clinic.entity.UserAccount;

import java.util.Optional;

public interface UserAccountRepo extends BaseRepository<UserAccount> {
    Optional<UserAccount> findUserAccount(String username, String password);

    Optional<UserAccount> findUserAccount(String username);
}
