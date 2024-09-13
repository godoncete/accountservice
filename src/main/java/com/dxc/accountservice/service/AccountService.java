package com.dxc.accountservice.service;

import com.dxc.accountservice.entity.Account;
import com.dxc.accountservice.entity.Customer;

import java.util.List;

public interface AccountService {

    List<Account> listarCuentasCliente(Long customerId);

    Account obtenerCuentaPorId(Long id);

    Account crearCuenta(Account cuenta);

    Account actualizarCuenta(Account cuenta);

    boolean eliminarCuenta(Long id);

    boolean addMoneyToBalance(Account account, int amount, Customer customer);

    boolean restMoneyToBalance(Account account, int amount, Customer customer);

    boolean eliminarCuentasPorCliente(Customer customer);

}
