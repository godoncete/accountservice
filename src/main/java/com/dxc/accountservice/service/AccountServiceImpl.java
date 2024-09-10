package com.dxc.accountservice.service;

import com.dxc.accountservice.entity.Account;
import com.dxc.accountservice.entity.Customer;
import com.dxc.accountservice.repository.AccountRepository;
import com.dxc.accountservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService  {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

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
        return accountRepository.save(cuenta);
    }

    @Override
    public Account actualizarCuenta(Account cuenta) {
        if(accountRepository.existsById(cuenta.getId())){
            return accountRepository.save(cuenta);
        }
        return null;
    }

    @Override
    public boolean eliminarCuenta(Long id) {
        if(accountRepository.existsById(id)){
            accountRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean addMoneyToBalance(Account account, int amount, Customer customer) {
     //Aquí se haría la lógica para añadir dinero a la cuenta del cliente
        if(accountRepository.existsById(account.getId()) && amount > 0){
            if(customerRepository.existsById(customer.getId())){
                account.setBalance(account.getBalance() + amount);
                accountRepository.save(account);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean restMoneyToBalance(Account account, int amount, Customer customer) {
        if(accountRepository.existsById(account.getId()) && amount > 0){
            if(customerRepository.existsById(customer.getId())){
                account.setBalance(account.getBalance() - amount);
                accountRepository.save(account);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminarCuentasPorCliente(Customer customer) {
//        List<Account> accounts =
        return false;
    }
}
