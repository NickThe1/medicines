package com.nick.software.medicines.account.repository;

import com.nick.software.medicines.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);

    Account findByEmail(String email);

    Account findByUsernameAndPassword(String username, String password);
}
