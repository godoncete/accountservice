package com.dxc.accountservice.domain.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceImplTest {

    @Test
    void givenCostumeId_whenListarCuentasCliente_thenAccountListNotNull() {
    }

    @Test
    void givenCostumerId_whenIdNotExist_thenCostumerNotFoundException() {
    }
    @Test
    void givenAccountIdAndCustomerId_whenGetByAccountIdAndCustomerId_thenAccountIsNotNull() {
    }
    @Test
    void givenAccountIdAndCustomerId_whenGetByAccountIdNotExistAndCustomerId_thenAccountNotFoundException(){

    }

    @Test
    void givenOneAccount_whenCrearCuenta_thenAccountCreated() {
    }
    @Test
    void givenOneAccount_whenInvalidAccount_thenMethodArgumentNotValidException() {
    }

    @Test
    void givenAccountAndBalance_whenRestMoneyToBalance_thenTrue() {
    }
    @Test
    void givenAccountAndBalance_whenRestInsuficientMoneyToBalance_thenInsuficientBalanceException() {
    }
}