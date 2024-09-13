package com.dxc.accountservice.repository;

import com.dxc.accountservice.entity.Account;
import com.dxc.accountservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAllByCustomer(Customer customer);

    Optional<Account> findByIdAndCustomer(Long accountId, Customer customer);
}
