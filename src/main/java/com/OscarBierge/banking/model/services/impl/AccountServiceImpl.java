package com.OscarBierge.banking.model.services.impl;

import com.OscarBierge.banking.model.domain.Account;
import com.OscarBierge.banking.model.dto.AccountDto;
import com.OscarBierge.banking.model.mapper.AccountMapper;
import com.OscarBierge.banking.model.services.iAccountService;
import com.OscarBierge.banking.model.repository.iAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements iAccountService {

    private iAccountRepository iAccountRepository;
    @Autowired
    public AccountServiceImpl(iAccountRepository iAccountRepository) {
        this.iAccountRepository = iAccountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = iAccountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {

        Account account = iAccountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {

        Account account = iAccountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));

        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = iAccountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {

        Account account = iAccountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));

        if (account.getBalance() < amount){
            throw new RuntimeException("Insuficient amount");
        }

        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = iAccountRepository.save(account);


        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = iAccountRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {

        Account account = iAccountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));

        iAccountRepository.deleteById(id);
    }
}
