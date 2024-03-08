package com.OscarBierge.banking.model.services;

import com.OscarBierge.banking.model.dto.AccountDto;

import java.util.List;

public interface iAccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);

    AccountDto withdraw(Long id, double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long id);
}
