package com.dxc.accountservice.repository;

import com.dxc.accountservice.entity.Account;
import com.dxc.accountservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAllByCustomer(Customer customer);

//    List<Account> findAllByCustomer_Id(Long customerId);
}
