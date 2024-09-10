package com.dxc.accountservice.service;

import com.dxc.accountservice.entity.Account;
import com.dxc.accountservice.entity.Customer;
import com.dxc.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService  {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public List<Account> listarCuentas() {
        return accountRepository.findAll();
    }

    @Override
    public Account obtenerCuentaPorId(Long id) {
        Optional<Account> cuenta = accountRepository.findById(id);
        if(cuenta.isPresent()){
            return cuenta.get();
        }
        return null;
    }

    @Override
    public Account crearCuenta(Account cuenta) {
        return null;
    }

    @Override
    public Account actualizarCuenta(Account cuenta) {
        return null;
    }

    @Override
    public void eliminarCuenta(Long id) {

    }

    @Override
    public void addMoneyToBalance(Account account, double amount, Customer customerId) {

    }

    @Override
    public void restMoneyToBalance(Account account, double amount, Customer customerId) {

    }

    @Override
    public void eliminarCuentasPorCliente(Customer customer) {

    }
}
