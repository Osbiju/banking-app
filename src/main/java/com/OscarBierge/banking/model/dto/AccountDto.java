package com.OscarBierge.banking.model.dto;

import lombok.Data;

import java.util.Objects;

@Data
public class AccountDto {
    private Long id;
    private String accountHolderName;
    private double balance;

//    public AccountDto() {
//    }

    public AccountDto(Long id, String accountHolderName, double balance) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDto that = (AccountDto) o;
        return Double.compare(balance, that.balance) == 0 && Objects.equals(id, that.id) && Objects.equals(accountHolderName, that.accountHolderName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountHolderName, balance);
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "id=" + id +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
