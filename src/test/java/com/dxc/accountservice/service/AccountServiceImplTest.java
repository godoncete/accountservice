package com.dxc.accountservice.service;

import com.dxc.accountservice.entity.Account;
import com.dxc.accountservice.entity.Customer;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @Test
    @Order(1)
    void listarCuentas() {
        List<Account> accounts = accountService.listarCuentas();
        System.out.println(accounts);
        assert !accounts.isEmpty();
    }

    @Test
    @Order(2)
    void obtenerCuentaPorId() {
        Account account = accountService.obtenerCuentaPorId(1L);
        System.out.println(account);
        assert account!= null;
    }

    @Test
    @Order(4)
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
    @Order(5)
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
    @Order(6)
    void eliminarCuenta() {
        boolean deleted = accountService.eliminarCuenta(1L);
        System.out.println("Deleted: " + deleted);
        assert deleted;
    }

    @Test
    @Order(7)
    void addMoneyToBalance() {
        Customer customer = Customer.builder().id(1L).build();
        Account account = accountService.obtenerCuentaPorId(2L);
        System.out.println("account: " + account);
        boolean added = accountService.addMoneyToBalance(account, 50, customer);
        System.out.println("account: " + account);
        System.out.println("Added: " + added);
        assert added;
    }

    @Test
    @Order(8)
    void restMoneyToBalance() {
        Customer customer = Customer.builder().id(1L).build();
        boolean added = accountService.addMoneyToBalance(accountService.obtenerCuentaPorId(2L), 50, customer);
        System.out.println("Rest: " + added);
        assert added;
    }

    @Test
    @Order(9)
    void eliminarCuentasPorCliente() {
        Customer customer = Customer.builder().id(1L).build();
        boolean deleted = accountService.eliminarCuentasPorCliente(customer);
        System.out.println("Deleted: " + deleted);
        assert deleted;
    }
}