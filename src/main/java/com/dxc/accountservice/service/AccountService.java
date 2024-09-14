package com.dxc.accountservice.service;

import com.dxc.accountservice.dto.AccountDtoRequest;
import com.dxc.accountservice.dto.AccountDtoResponse;
import com.dxc.accountservice.dto.AddAmountBalanceDto;
import com.dxc.accountservice.dto.RestMoneyBalanceDto;
import com.dxc.accountservice.entity.Account;
import com.dxc.accountservice.entity.Customer;

import java.util.List;

public interface AccountService {


    AccountDtoResponse getByAccountIdAndCustomerId(Long accountId, Long customerId);
    List<AccountDtoResponse> listarCuentasCliente(Long customerId);
    AccountDtoResponse crearCuenta(AccountDtoRequest accountDtoRequest);
    AccountDtoResponse actualizarCuenta(AccountDtoRequest accountDtoRequest, Long accountId);
    boolean addMoneyToBalance(AddAmountBalanceDto addAmountBalanceDto);
    boolean restMoneyToBalance(RestMoneyBalanceDto restMoneyBalanceDto);
    String comprobarPrestamo(Long customerId,Integer monto);

    String eliminarCuenta(Long id);

//    boolean eliminarCuentasPorCliente(Customer customer);


}
