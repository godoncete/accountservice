package com.dxc.accountservice.service;

import com.dxc.accountservice.dto.AccountDtoRequest;
import com.dxc.accountservice.dto.AccountDtoResponse;
import com.dxc.accountservice.dto.AddAmountBalanceDto;
import com.dxc.accountservice.dto.RestMoneyBalanceDto;
import com.dxc.accountservice.entity.Account;
import com.dxc.accountservice.entity.Customer;
import com.dxc.accountservice.exception.CustomerNotfoundException;
import com.dxc.accountservice.mapper.AccountMapper;
import com.dxc.accountservice.repository.AccountRepository;
import com.dxc.accountservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService  {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountMapper accountMapper;



    @Override
    public List<AccountDtoResponse> listarCuentasCliente(Long customerId){
        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new CustomerNotfoundException("Customer not found with id: " + customerId));
        return accountMapper.toAccountDtoResponseList(accountRepository.findAllByCustomer(customer));
    }

    @Override
    @Transactional
    public AccountDtoResponse crearCuenta(AccountDtoRequest accountDtoRequest) {
       Account cuenta  = accountMapper.toAccount(accountDtoRequest);
       return accountMapper.toAccountDtoResponse(accountRepository.save(cuenta));
    }
    @Override
    @Transactional
    public AccountDtoResponse actualizarCuenta(AccountDtoRequest accountDtoRequest,Long accountId) {
        if(accountRepository.existsById(accountId)){
            return  accountMapper.toAccountDtoResponse(accountRepository.save(accountMapper.toAccount(accountDtoRequest)));
        }
        throw new RuntimeException("Account not found with id: " + accountId);
    }

    @Override
    public boolean eliminarCuenta(Long id) {
        if(customerRepository.existsById(id)){
            accountRepository.deleteById(id);
            return true;
        }
        return false;
    }














    @Override
    @Transactional(readOnly = true)
    public Account obtenerCuentaPorId(Long id) {
        Optional<Account> cuenta = accountRepository.findById(id);
        if(cuenta.isPresent()){
            return cuenta.get();
        }
        return null;
    }
    @Override
    @Transactional
    public boolean addMoneyToBalance(AddAmountBalanceDto addAmountBalanceDto) {
     //Aquí se haría la lógica para añadir dinero a la cuenta del cliente
        if(accountRepository.existsById(addAmountBalanceDto.getAccountId())){
            if(customerRepository.existsById(addAmountBalanceDto.getCustomerId())){
                Account account = accountRepository.findById(addAmountBalanceDto.getAccountId()).get();
                account.setBalance(account.getBalance() + addAmountBalanceDto.getAmount());
                accountRepository.save(account);
                return true;
            }
            throw new CustomerNotfoundException("Customer not found with id: " + addAmountBalanceDto.getCustomerId());
        }
        throw new RuntimeException("Account not found with id: " + addAmountBalanceDto.getAccountId());
    }
    @Override
    @Transactional
    public boolean restMoneyToBalance(RestMoneyBalanceDto restMoneyBalanceDto) {
        Account account = accountRepository.findById(restMoneyBalanceDto.getAccountId()).orElseThrow();
        if(account != null){
            if(customerRepository.existsById(restMoneyBalanceDto.getCustomerId())){
                if(account.getBalance() >= restMoneyBalanceDto.getAmount()){

                }
                return true;
            }
            throw new CustomerNotfoundException("Customer not found with id: " + restMoneyBalanceDto.getCustomerId());
        }
        throw new RuntimeException("Account not found with id: " + restMoneyBalanceDto.getAccountId());
    }


    @Override
    public boolean eliminarCuentasPorCliente(Customer customer) {
        List<Account> accounts = accountRepository.findAllByCustomer(customer);
        if(!accounts.isEmpty()){
            accountRepository.deleteAll(accounts);
            return true;
        }
        return false;
    }
    @Override
    public AccountDtoResponse getByAccountIdAndCustomerId(Long accountId, Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new CustomerNotfoundException("Customer not found with id: " + customerId));
        Optional<Account> account = accountRepository.findByIdAndCustomer(accountId, customer);
        if(account.isPresent()){
            return accountMapper.toAccountDtoResponse(account.get());
        }
        throw new CustomerNotfoundException("Customer not found with id:" + customerId);
    }
}
