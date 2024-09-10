package com.dxc.accountservice.repository;

import com.dxc.accountservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAllByCustomer(Long customerId);

    List<Account> findAllByCustomer_Id(Long customerId);
}
