package com.dxc.accountservice.repository;

import com.dxc.accountservice.persistence.entity.Account;
import com.dxc.accountservice.persistence.entity.Customer;
import com.dxc.accountservice.persistence.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void findAllByCustomer() {
        Customer customer = Customer.builder().id(1L).build();
        List<Account> accounts = accountRepository.findAllByCustomer(customer);
        assert !accounts.isEmpty();
    }
}