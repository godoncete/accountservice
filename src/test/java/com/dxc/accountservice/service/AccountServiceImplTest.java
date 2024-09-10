package com.dxc.accountservice.service;

import com.dxc.accountservice.entity.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @Test
    void listarCuentas() {
        List<Account> accounts = accountService.listarCuentas();
        System.out.println(accounts);
        assert !accounts.isEmpty();
    }

    @Test
    void obtenerCuentaPorId() {
        Account account = accountService.obtenerCuentaPorId(1L);
        System.out.println(account);
        assert account!= null;
    }

    @Test
    void crearCuenta() {
    }

    @Test
    void actualizarCuenta() {
    }

    @Test
    void eliminarCuenta() {
    }

    @Test
    void addMoneyToBalance() {
    }

    @Test
    void restMoneyToBalance() {
    }

    @Test
    void eliminarCuentasPorCliente() {
    }
}