package com.dxc.accountservice.service;

import com.dxc.accountservice.entity.Account;
import com.dxc.accountservice.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
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
        Account account = Account.builder()
                .customer(Customer.builder().id(1L).build())
                .type("Ahorro")
                .openingDate(LocalDate.now())
                .balance(100)
                .build();
        Account accountCreated = accountService.crearCuenta(account);
        System.out.println(accountCreated);
        assert accountCreated != null;

    }

    @Test
    void actualizarCuenta() {
        Account account = Account.builder()
                .id(1L)
                .customer(Customer.builder().id(1L).build())
                .type("C")
                .balance(100)
                .build();
        Account accountUpdated = accountService.actualizarCuenta(account);
        System.out.println(accountUpdated);
        assert accountUpdated != null;
    }

    @Test
    void eliminarCuenta() {
        boolean deleted = accountService.eliminarCuenta(1L);
        System.out.println("Deleted: " + deleted);
        assert deleted;
    }

    @Test
    void addMoneyToBalance() {
    }

    @Test
    void restMoneyToBalance() {
    }

    @Test
    void eliminarCuentasPorCliente() {
        Customer customer = Customer.builder().id(1L).build();
        boolean deleted = accountService.eliminarCuentasPorCliente(customer);
        System.out.println("Deleted: " + deleted);
        assert deleted;
    }
}