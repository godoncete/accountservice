package com.dxc.accountservice.persistence.repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryTest {

    @Test
    void givenOneCustomer_whenFindAllByCustomer_thenIsNotNull() {
    }

     @Test
    void givenOneCustomer_whenFindAllByCustomerNotExist_ThenCustomerNotFoundException() {
    }
     @Test
    void givenAccountIdAndCustumer_whenFindByIdAndCustomer_thenOneAccount() {
    }
     @Test
    void givenAccountIdAndCustumer_whenFindByIdNotExistAndCustomer_thenAccountNotFoundException() {
    }

    @Test
    void givenOneCostumerAndAmount_whenRestMoneyAllAccount_thenIsTrue() {
    }

    @Test
    void givenOneCostumerAndAmount_whenInsufficientBalance_thenInsufficientBalanceException() {
    }
}