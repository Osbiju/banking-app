package com.OscarBierge.banking.model.repository;

import com.OscarBierge.banking.model.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iAccountRepository extends JpaRepository<Account, Long> {
}
