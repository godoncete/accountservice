package com.dxc.accountservice.service;

import com.dxc.accountservice.entity.Account;
import com.dxc.accountservice.entity.Customer;

import java.util.List;

public interface AccountService {

    List<Account> listarCuentas();

    Account obtenerCuentaPorId(Long id);

    Account crearCuenta(Account cuenta);

    Account actualizarCuenta(Account cuenta);

    void eliminarCuenta(Long id);

    void addMoneyToBalance(Account account, double amount, Customer customerId);

    void restMoneyToBalance(Account account, double amount, Customer customerId);

    void eliminarCuentasPorCliente(Customer customer);

}
