package com.dxc.accountservice.service;

import com.dxc.accountservice.dto.AccountDtoRequest;
import com.dxc.accountservice.dto.AccountDtoResponse;
import com.dxc.accountservice.entity.Account;
import com.dxc.accountservice.entity.Customer;

import java.util.List;

public interface AccountService {


    AccountDtoResponse getByAccountIdAndCustomerId(Long accountId, Long customerId);
    List<AccountDtoResponse> listarCuentasCliente(Long customerId);
    AccountDtoResponse crearCuenta(AccountDtoRequest accountDtoRequest);

    Account obtenerCuentaPorId(Long id);



    Account actualizarCuenta(Account cuenta);

    boolean eliminarCuenta(Long id);

    boolean addMoneyToBalance(Account account, int amount, Customer customer);

    boolean restMoneyToBalance(Account account, int amount, Customer customer);

    boolean eliminarCuentasPorCliente(Customer customer);


}
